import { Component, OnInit, Input} from '@angular/core';
import { ProyectoService } from './services/proyecto.service';
import { Proyecto } from './interface/proyecto';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css'],
  providers: [ProyectoService]
})

export class ProyectoComponent implements OnInit {

  destinatarioElegido: number = 0;
  odsElegido: number = 0;
  proyectos: Proyecto[] = [];


  constructor(public ProyectoService: ProyectoService) { }

  ngOnInit(): void {
    this.ProyectoService.getProyecto().subscribe(datosProyectos => (this.proyectos = datosProyectos));
  }

  alCambiarDestinatario(opcionSeleccionada: number): void{
		this.destinatarioElegido = opcionSeleccionada;
    this.odsElegido = 0;
	}

  alCambiarOds(opcionSeleccionada: number){
    this.odsElegido = opcionSeleccionada;
    this.destinatarioElegido = 0;
  }

}
