import { Injectable } from '@angular/core';
import { Proyecto } from 'src/app/proyecto/interface/proyecto'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  constructor(private _http: HttpClient) { }

  getProyecto(): Observable<Proyecto[]>{
    const path = "https://localhost:44382/api/Proyecto";
    return this._http.get<Proyecto[]>(path);
  }
}
