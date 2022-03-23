import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { Ods } from '../interface/ods';
import { OdsService } from '../services/ods.service';

@Component({
  selector: 'app-ods-lista',
  templateUrl: './ods-lista.component.html',
  styleUrls: ['./ods-lista.component.css']
})
export class OdsListaComponent implements OnInit {

	odsElegido: number = 1;
	ods: Ods[] = [];

	@Output()
	globalElegida: EventEmitter<number> = new EventEmitter<number>();

	constructor(private odsService: OdsService) { }

	ngOnInit(): void {
		this.odsService.getOds().subscribe(datosOds => (this.ods = datosOds));
	}
	cambiarOds (){
		this.globalElegida.emit(this.odsElegido);
	}

}
