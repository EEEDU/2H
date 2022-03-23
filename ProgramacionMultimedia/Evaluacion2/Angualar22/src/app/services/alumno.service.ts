import { Injectable } from '@angular/core';
import { Alumno } from 'src/app/alumno'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AlumnoService{

    constructor(private _http: HttpClient){

    }

    getAlumnos(): Observable<Alumno[]>{
        const path = "https://localhost:44340/api/Alumnos";
        return this._http.get<Alumno[]>(path);
    }

    getAlumnosPorNombre(nombre: string): Observable<Alumno>{
        const path = "https://localhost:44340/api/Alumnos/" + nombre;
        return this._http.get<Alumno>(path);
    }

}