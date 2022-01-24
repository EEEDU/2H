import { Component } from '@angular/core';

@Component({
    selector: 'lista-alumno',
    templateUrl: 'app/Alumno/AlumnoLista.component.html',
    styleUrls: ['app/Alumno/Alumno.component.css']
})

export class AlumnoListaComponent {
    alumos: any[] = [
        { nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: 2/28/1958, sexo: 'Hombre' },
        { nombre: 'Eduardo', apellidos: 'Guerrero', direccion: 'Zaragoza', edad: 9/15/2002, sexo: 'Hombre'},
    ];

    alCambiar(opcionSeleccionada: string): void {

    }

    getNumTodos(): number{
        return this.alumnos.length;
    }
    getNumHombres(): number{
        return this.alumnos.filter(a => a.sexo == "Hombre").length;
    }
    getNumMujeres(): number{
        return this.alumnos.filter(a => a.sexo == "Mujer").length;
    }
}
