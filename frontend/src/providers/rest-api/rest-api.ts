import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from '../../../node_modules/rxjs/Observable';

/*
  Generated class for the RestApiProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class RestApiProvider {

  constructor(public http: Http) {
    console.log('Hello RestApiProvider Provider');
  }

  public getCategorias():Observable<any[]>{
    return this.http.get('../../assets/data/peen-app-categorias.json').map(res=>res.json());
  }

  public getEventos(categoriaId:number):Observable<any[]>{
    return this.http.get('../../assets/data/peen-app-eventos.json').map(res=>res.json());
  }

  public getEvento(key:number):Observable<any>{
    return this.http.get('../../assets/data/peen-app-evento.json').map(res=>res.json());
  }
}
