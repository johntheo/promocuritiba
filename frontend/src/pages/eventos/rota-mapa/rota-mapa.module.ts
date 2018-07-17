import { NgModule } from '@angular/core';
import { RotaMapaPage } from './rota-mapa';
import { IonicPageModule } from 'ionic-angular';

@NgModule({
  declarations: [
    RotaMapaPage,
  ],
  imports: [
    IonicPageModule.forChild(RotaMapaPage),
  ],
  exports: [
    RotaMapaPage
  ]
})
export class RotaMapaPageModule {}
