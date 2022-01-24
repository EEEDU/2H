import { Component } from '@angular/core';

@Component({
    selector: 'cuantos-alumnos',
    templateUrl: 'app/Alumno/AlumnoCount.component.html',
    styleUrls: ['app/Alumno/AlumnoCount.component.css']
})

export class AlumnosCountComponent {
    @Input() 
    todos: number;

    @Input()
    hombres: number;

    @Input()
    mujeres: number;
}