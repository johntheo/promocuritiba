import { NgModule } from '@angular/core';
import { DetalhePage } from './detalhe';
import { IonicPageModule } from 'ionic-angular';
// Import ionic2-rating module
import { Ionic2RatingModule } from 'ionic2-rating';


@NgModule({
  declarations: [
    DetalhePage,
  ],
  imports: [
    IonicPageModule.forChild(DetalhePage),
    Ionic2RatingModule // Put ionic2-rating module here
  ],
  exports: [
    DetalhePage
  ]
})
export class DetalhePageModule {}
