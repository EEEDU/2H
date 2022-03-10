import { Injectable } from '@angular/core';
import { Destinatario } from 'src/app/destinatario/interface/destinatario'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DestinatarioService {

  constructor(private _http: HttpClient) { }

  getDestinatario(): Observable<Destinatario[]>{
    const path = "https://localhost:44382/api/Destinatario";
    return this._http.get<Destinatario[]>(path);
  }

  getDestinatarioPorNombre(ID: number): Observable<Destinatario>{
    const path = "https://localhost:44382/api/Destinatario/" + ID;
    return this._http.get<Destinatario>(path);
}
}
