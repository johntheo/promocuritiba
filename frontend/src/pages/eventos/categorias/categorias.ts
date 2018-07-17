import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, LoadingController , ToastController } from 'ionic-angular';
import { AngularFireDatabase} from 'angularfire2/database';

@IonicPage()
@Component({
  selector: 'page-categorias',
  templateUrl: 'categorias.html'
})
export class CategoriasPage {
  category: any[] = [];
  viewType: string = "grid";

  constructor(public navCtrl: NavController,public navParams: NavParams,public loadingCtrl: LoadingController, public afDB: AngularFireDatabase ,private toastCtrl: ToastController ) {

    let loadingPopup = this.loadingCtrl.create({
      spinner: 'crescent', 
      content: ''
    });
    loadingPopup.present();

    this.afDB.list('/categorias').subscribe(categoryItems => {
      this.category = categoryItems;
      loadingPopup.dismiss();
    });
    
  }


  //*********** Open list page  **************/
  openList(categoriaId, categoriaNome){
      //this.navCtrl.push('ListaPage',{categoriaId:categoriaId, categoriaNome:categoriaNome}); 
      console.log("TODO");
  }


}
