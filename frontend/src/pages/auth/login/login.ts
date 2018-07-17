import { Component } from '@angular/core';
import { IonicPage, NavController, LoadingController, AlertController } from 'ionic-angular';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthData } from '../../../providers/auth-data';


@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
  public loginForm: any;
  public backgroundImage: any = "./assets/bg1.jpg";
  public imgLogo: any = "./assets/icon/icon.png";

  constructor(public navCtrl: NavController, public authData: AuthData, public fb: FormBuilder, public alertCtrl: AlertController,public loadingCtrl: LoadingController) {
      let EMAIL_REGEXP = /^[a-z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-z0-9]([a-z0-9-]*[a-z0-9])?(\.[a-z0-9]([a-z0-9-]*[a-z0-9])?)*$/i;
      this.loginForm = fb.group({
            email: ['', Validators.compose([Validators.required, Validators.pattern(EMAIL_REGEXP)])],
            password: ['', Validators.compose([Validators.minLength(6), Validators.required])]
      });
  }

  login(){
      if (!this.loginForm.valid){
          //this.presentAlert('Username password can not be blank')
          console.log("error");
      } else {
        let loadingPopup = this.loadingCtrl.create({
          spinner: 'crescent', 
          content: ''
        });
        loadingPopup.present();

        this.authData.loginUser(this.loginForm.value.email, this.loginForm.value.password)
        .then( authData => {
          console.log("Auth pass");
          loadingPopup.dismiss();
          this.navCtrl.setRoot('CategoriasPage');
        }, error => {
          var errorMessage: string = error.message;
          loadingPopup.dismiss().then( () => {
              this.presentAlert(errorMessage)
          });
        });
      }
  }
  
  loginWithFacebook(){
    let loadingPopup = this.loadingCtrl.create({
      spinner: 'crescent', 
      content: ''
    });
    loadingPopup.present();
    
    this.authData.loginWithFacebook()
    .then( authData => {
      console.log("Facebok login OK");
      loadingPopup.dismiss();
      this.navCtrl.setRoot('CategoriasPage');
    }, error => {
      var errorMessage: string = error.message;
      loadingPopup.dismiss().then( () => {
          this.presentAlert(errorMessage)
      });
    });
  }

  forgot(){
    this.navCtrl.push('ForgotPage');
  }

  createAccount(){
    this.navCtrl.push('RegisterPage');
  }
  presentAlert(title) {
    let alert = this.alertCtrl.create({
      title: title,
      buttons: ['OK']
    });
    alert.present();
  }

}
