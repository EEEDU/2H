import { Component, OnInit } from '@angular/core';
import { DestinatarioService } from './services/destinatario.service';
import { Destinatario } from './interface/destinatario';

@Component({
  selector: 'app-destinatario',
  templateUrl: './destinatario.component.html',
  styleUrls: ['./destinatario.component.css'],
	providers: [DestinatarioService]

})

export class DestinatarioComponent implements OnInit {

  destinatarios: Destinatario[] = [];

  constructor(public destinatarioService: DestinatarioService) { }

  ngOnInit(): void {
    this.destinatarioService.getDestinatario().subscribe(datosDestinatarios => (this.destinatarios = datosDestinatarios));
  }

  public getDestinatarios(): Destinatario[] {
    return this.destinatarios;
  }

}
