import { Injectable } from '@angular/core'
import {Alumno } from 'src/app/alumno'

@Injectable()
export class AlumnoService{
    getAlumnos(): Alumno[] {
        return [
            { nombre: 'Borja', apellidos:'Colas', direccion: 'Zaragoza', fnac: '2/3/2002', sexo: 'Hombre'},
			{ nombre: 'Guillermo', apellidos: 'Alconchel', direccion: 'Madrid', fnac: '5/4/1235', sexo: 'Mujer'}
        ]
    }
}