import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/alumno'
import { AlumnoService } from 'src/app/alumnoService'

@Component({
	selector: 'app-alumno-lista',
	templateUrl: './alumno-lista.component.html',
	styleUrls: ['./alumno-lista.component.css'],
	providers: [AlumnoService]
})
export class AlumnoListaComponent implements OnInit {

	seleccion: string = 'Todos';

	alumnos: Alumno[];
	constructor( public losAlumnos: AlumnoService){
	}
	
	ngOnInit(): void {
		this.alumnos = this. losAlumnos.getAlumnos();
	}


	alCambiar(opcionSeleccionada: string): void{
		this.seleccion = opcionSeleccionada;
	}

	getTodos(): number{
		return this.alumnos.length;
	}

	getHombres(): number{
		return this.alumnos.filter(a => a.sexo == 'Hombre').length;
	}

	getMujeres(): number{
		return this.alumnos.filter(a => a.sexo == 'Mujer').length;
	}
}
