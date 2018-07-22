import { NgModule } from '@angular/core';
import { ListaMapaPage } from './lista-mapa';
import { IonicPageModule } from 'ionic-angular';

@NgModule({
  declarations: [
    ListaMapaPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaMapaPage),
  ],
  exports: [
    ListaMapaPage
  ]
})
export class ListaMapaPageModule {}
