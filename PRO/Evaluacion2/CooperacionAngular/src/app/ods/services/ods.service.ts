import { Injectable } from '@angular/core';
import { Ods } from 'src/app/ods/interface/ods'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OdsService {

  constructor(private _http: HttpClient) { }

  getOds(): Observable<Ods[]>{
    const path = "https://localhost:44382/api/Ods";
    return this._http.get<Ods[]>(path);
  }
}