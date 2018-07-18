import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, LoadingController , ToastController } from 'ionic-angular';
import { AngularFireDatabase} from 'angularfire2/database';
import { RestApiProvider } from '../../../providers/rest-api/rest-api';

@IonicPage()
@Component({
  selector: 'page-categorias',
  templateUrl: 'categorias.html'
})
export class CategoriasPage {
  category: any[] = [];
  viewType: string = "grid";

  constructor(public navCtrl: NavController,public navParams: NavParams,public loadingCtrl: LoadingController, public afDB: AngularFireDatabase ,private toastCtrl: ToastController,private restApi: RestApiProvider ) {

    let loadingPopup = this.loadingCtrl.create({
      spinner: 'crescent', 
      content: ''
    });
    loadingPopup.present();

    /*this.afDB.list('/categorias').subscribe(categoryItems => {
      this.category = categoryItems;
      loadingPopup.dismiss();
    });*/
    this.restApi.getCategorias().subscribe(categotyItems => {
      this.category = categotyItems;
      loadingPopup.dismiss();
    })
    
  }


  //*********** Open list page  **************/
  openList(categoriaId, categoriaNome){
      this.navCtrl.push('ListaPage',{categoriaId:categoriaId, categoriaNome:categoriaNome}); 
      //console.log("TODO");
  }


}
