import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { Clase } from './interface/clase';
import { ClaseService } from './service/clase.service';

@Component({
    selector: 'app-clase',
    templateUrl: './clase.component.html',
    styleUrls: ['./clase.component.css']
})
export class ClaseComponent implements OnInit {

	clases: Clase[] = [];
	claseElegida: number = 1;

	@Output()
	globalElegida: EventEmitter<number> = new EventEmitter<number>();

	constructor( public claseService: ClaseService){}
	
	ngOnInit(): void {
		// this.alumnos = this.losAlumnos.getAlumnos();
		this.claseService.getAllClases().subscribe(datosClases => (this.clases = datosClases));
	}

	getClases(){
		console.log(this.clases);
	}
	
	cuandoCambiemos(){
		this.globalElegida.emit(this.claseElegida);
	}
}
