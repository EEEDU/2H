import { Injectable } from '@angular/core';
import { Pais } from 'src/app/pais/pais'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaisService {

  constructor(private _http: HttpClient) { }

  getPais(): Observable<Pais[]>{
    const path = "https://localhost:44382/api/Pais";
    return this._http.get<Pais[]>(path);
  }
}
