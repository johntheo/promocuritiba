import { Component, ViewChild } from '@angular/core';
import { Nav, Platform, LoadingController } from 'ionic-angular';
import { AuthData } from '../providers/auth-data';
import { AngularFireAuth } from 'angularfire2/auth';

//***********  ionic-native **************/
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';


@Component({
  templateUrl: 'app.html'
})
export class MyApp {

  @ViewChild(Nav) nav: Nav;
  rootPage: string = 'LoginPage';
  dashboardMenu:Array<any> = [];
  pages: Array<any>;
  logged: boolean = false;
  displayName;
  displayEmail;
  displayPhoto;

  constructor(public afAuth: AngularFireAuth, public authData: AuthData, public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen, public loadingCtrl: LoadingController) {
    this.initializeApp();

    this.pages = [ 
      // { icon:'call', title:'Contact us', component: 'ContactPage' },
      { icon:'calendar', title:'Eventos', component: 'CategoriasPage'},
      { icon:'bookmark', title:'Version 1.0', component: "" }    
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      
      this.afAuth.authState.subscribe( user => {
      if (user) {
        this.logged  = true;
        this.displayName = user.displayName; 
        this.displayEmail = user.email;
        //this.displayPhoto = user.photoURL;//TODO: salvar foto no firebase
        this.displayPhoto = 'https://firebasestorage.googleapis.com/v0/b/relig-app.appspot.com/o/avatar.png?alt=media&token=1f042aba-8398-4e55-837b-a823990899cf'
        this.rootPage = 'CategoriasPage';
        //authObserver.unsubscribe();
      } else {
        this.logged = false;
        this.displayName = 'Visitante';
        this.displayEmail = '-';
        this.displayPhoto = 'https://firebasestorage.googleapis.com/v0/b/relig-app.appspot.com/o/avatar.png?alt=media&token=1f042aba-8398-4e55-837b-a823990899cf';
        this.rootPage = 'LoginPage';
        //authObserver.unsubscribe();
      }
    });
      
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
  toggleDetails(menu) {
    if (menu.showDetails) {
        menu.showDetails = false;
        menu.icon = 'ios-add-outline';
    } else {
        menu.showDetails = true;
        menu.icon = 'ios-remove-outline';
    }
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    // page.component = item array.component --> 
    //this.nav.setRoot(page.component);
    this.nav.setRoot(page.component).catch(err => console.error(err));
  }
  
  logout(){
    let loadingPopup = this.loadingCtrl.create({
          spinner: 'crescent', 
          content: ''
        });
    loadingPopup.present();
    
    this.authData.logoutUser()
        .then( authData => {
          console.log("Logout com sucesso");
          //Resetando as variaveis do usuario
          this.displayName = 'Visitante';
          this.displayEmail = '-';
          this.displayPhoto = 'https://firebasestorage.googleapis.com/v0/b/relig-app.appspot.com/o/avatar.png?alt=media&token=1f042aba-8398-4e55-837b-a823990899cf';
          loadingPopup.dismiss();
          
          this.nav.setRoot('LoginPage').catch(err => console.error(err));
        }, error => {
          console.log("Erro ao fazer logout");
          loadingPopup.dismiss();
        });
  }

}
