import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import { Clase } from '../interface/clase';

@Injectable({
  providedIn: 'root'
})
export class ClaseService {
  
  private clases :Clase[] = []; 

  constructor( private _http: HttpClient) { }

  getAllClases(): Observable<Clase[]>{
    const path = "https://localhost:44340/api/Clases";
    return this._http.get<Clase[]>(path);
  }
}
