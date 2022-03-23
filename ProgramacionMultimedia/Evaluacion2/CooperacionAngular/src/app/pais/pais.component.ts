import { Component, OnInit } from '@angular/core';
import { PaisService } from './pais.service';
import { Pais } from './pais';

@Component({
  selector: 'app-pais',
  templateUrl: './pais.component.html',
  styleUrls: ['./pais.component.css'],
	providers: [PaisService]

})
export class PaisComponent implements OnInit {

  pais: Pais[] = [];

  constructor(public paisService: PaisService) { }

  ngOnInit(): void {
    this.paisService.getPais().subscribe(datosPais => (this.pais = datosPais));
  }

}
