import { Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import { Destinatario } from '../interface/destinatario';
import { DestinatarioService } from '../services/destinatario.service';

@Component({
	selector: 'app-destinatario-lista',
	templateUrl: './destinatario-lista.component.html',
	styleUrls: ['./destinatario-lista.component.css']
})
export class DestinatarioListaComponent implements OnInit {

	destinatarioElegido: number = 1;
	destinatarios: Destinatario[] = [];

	@Output()
	globalElegida: EventEmitter<number> = new EventEmitter<number>();

	constructor(private destinatarioService: DestinatarioService) { }

	ngOnInit(): void {
		this.destinatarioService.getDestinatario().subscribe(datosDestinatario => (this.destinatarios = datosDestinatario));
	}
	cambiarDestinatario (){
		this.globalElegida.emit(this.destinatarioElegido);
	}

}