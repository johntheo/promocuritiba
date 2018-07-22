import { NgModule } from '@angular/core';
import { ListaPage } from './lista';
import { IonicPageModule } from 'ionic-angular';
// Import ionic2-rating module
import { Ionic2RatingModule } from 'ionic2-rating';

@NgModule({
  declarations: [
    ListaPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaPage),
    Ionic2RatingModule // Put ionic2-rating module here
  ],
  exports: [
    ListaPage
  ]
})
export class ListaPageModule {}
