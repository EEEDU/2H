import { Component, OnInit } from '@angular/core';
import { Alumno } from '../alumno';
import { ActivatedRoute } from '@angular/router';
import { AlumnoService } from '../services/alumno.service';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css'],
})

export class AlumnoComponent implements OnInit {
  
  alumno: Alumno | undefined;

  constructor (private alumnoService: AlumnoService, private activedRouter: ActivatedRoute){}

  ngOnInit () {
    let nomAlumno: string = this.activedRouter.snapshot.params['nombre'];
    this.alumnoService.getAlumnosPorNombre(nomAlumno).subscribe(alumnosDatos => (this.alumno = alumnosDatos));
  }
  
  // columnas: number = 2;
  // nombre: string = 'Borja';
  // apellidos: string = 'Colas';
  // direccion: string = 'Zaragoza';
  // edad: number = 99;

  // visibles: boolean = false;

  // alternarVisibles(): void {
  //   this.visibles = !this.visibles;
  // }
}


