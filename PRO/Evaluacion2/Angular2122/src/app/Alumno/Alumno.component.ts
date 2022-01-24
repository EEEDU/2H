import { Component } from '@angular/core';

@Component({
    selector: 'el-alumno',
    templateUrl: 'app/Alumno/Alumno.component.html',
    //styleUrls: ['app/Alumno/Alumno.component.css']
})

export class AlumnoComponent {
    columns: number = 2;
    nombre: string = 'Perico';
    apellidos: string = 'Delgado';
    direccion: string = 'Segovia City';
    edad: number = 60;
}