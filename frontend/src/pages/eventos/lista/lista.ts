import { Component, ViewChild, ElementRef } from '@angular/core';
import { IonicPage, NavController, NavParams, ModalController, LoadingController } from 'ionic-angular';
import { AngularFireDatabase, FirebaseListObservable, FirebaseObjectObservable } from 'angularfire2/database';
import { RestApiProvider } from '../../../providers/rest-api/rest-api';
// import 'rxjs/add/operator/map'; // you might need to import this, or not depends on your setup
// import { GalleryModal } from 'ionic-gallery-modal';
// declare var google;

@IonicPage()
@Component({
  selector: 'page-lista',
  templateUrl: 'lista.html'
})
export class ListaPage {
  @ViewChild('map') map3Element: ElementRef;
  categoriaId: any;
  categoriaNome: any;
  items: any[] = [];

  viewMode: string = "map";
  map: any;
  mapList: FirebaseListObservable<any[]>;
  mapListArray: any = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public modalCtrl: ModalController, public loadingCtrl: LoadingController, public afDB: AngularFireDatabase, public restApi:RestApiProvider) {

    let loadingPopup = this.loadingCtrl.create({
      spinner: 'crescent',
      content: ''
    });

    loadingPopup.present();
    this.categoriaId = this.navParams.get('categoriaId');
    this.categoriaNome = this.navParams.get('categoriaNome');
    /*this.afDB.list('/eventos', {
      query: {
        orderByChild: "categoriaId",
        equalTo: parseInt(this.categoriaId)
      }
    }).subscribe(listItems => {
      this.items = listItems;
      loadingPopup.dismiss()
    });*/
    this.restApi.getEventos(this.categoriaId).subscribe(listItems => {
      this.items = listItems;
      loadingPopup.dismiss();
    })
  }

  goToDetail(itemId) {
    this.navCtrl.push('DetalhePage', { itemId: itemId });
  }


  showMap() {
    let mapModal = this.modalCtrl.create('ListaMapaPage', {
      categoryId: this.categoriaId
    });
    //let profileModal = this.modalCtrl.create(MapDetailPage, {lat: deviceNum,lng:lng});
    mapModal.present();
  }

}
