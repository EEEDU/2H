import { Component } from '@angular/core';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css'],
})

export class AlumnoComponent {
  columnas: number = 2;
  nombre: string = 'Borja';
  apellidos: string = 'Colas';
  direccion: string = 'Zaragoza';
  edad: number = 99;

  visibles: boolean = false;

  alternarVisibles(): void {
    this.visibles = !this.visibles;
  }
}


