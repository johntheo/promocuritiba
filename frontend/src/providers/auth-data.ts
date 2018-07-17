import { Injectable } from '@angular/core';
import { Platform, LoadingController } from 'ionic-angular';
import { AngularFireAuth } from 'angularfire2/auth';
import * as firebase from 'firebase/app';

import { Facebook} from '@ionic-native/facebook';

@Injectable()
export class AuthData {
  constructor(
    public afAuth: AngularFireAuth, 
    private platform: Platform,
    private facebook: Facebook,
    private loadingCtrl: LoadingController) {
  }

  loginUser(newEmail: string, newPassword: string): firebase.Promise<any> {
    return this.afAuth.auth.signInWithEmailAndPassword(newEmail,newPassword)
  }
  
  //obtido de: https://github.com/angular/angularfire2/blob/master/docs/ionic/v3.md
  //ver também: https://github.com/rodrigoreal/ionic3-angularfire-login/blob/master/src/providers/auth/auth.ts
  loginWithFacebook() {
    if (this.platform.is('cordova')) {
      return this.facebook.login(['email', 'public_profile']).then(res => {
        const facebookCredential = firebase.auth.FacebookAuthProvider.credential(res.authResponse.accessToken);
        return this.afAuth.auth.signInWithCredential(facebookCredential);
      })
    }
    else {
      return this.afAuth.auth.signInWithPopup(new firebase.auth.FacebookAuthProvider());
    }
  }

  resetPassword(email: string): firebase.Promise<any> {
    return this.afAuth.auth.sendPasswordResetEmail(email);
  }

  logoutUser(): firebase.Promise<any> {
    return this.afAuth.auth.signOut();
  }
  
  registerUser(name: string, email: string, password: string,phone: number): firebase.Promise<any> {
    return this.afAuth.auth.createUserWithEmailAndPassword(email, password).then((newUser) => {
      firebase.database().ref('/userProfile').child(newUser.uid).set({
          email: email,
          name: name,
          phone: phone
      });
    });
  }

}

