import { NgModule } from '@angular/core';
import { CategoriasPage } from './categorias';
import { IonicPageModule } from 'ionic-angular';

@NgModule({
  declarations: [
    CategoriasPage,
  ],
  imports: [
    IonicPageModule.forChild(CategoriasPage),
  ],
  exports: [
    CategoriasPage
  ]
})
export class CategoriasPageModule {}
