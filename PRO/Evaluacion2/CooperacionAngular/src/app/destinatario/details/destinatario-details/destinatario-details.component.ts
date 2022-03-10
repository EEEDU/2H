import { Component, OnInit } from '@angular/core';
import { Destinatario } from '../../interface/destinatario';
import { ActivatedRoute } from '@angular/router';
import { DestinatarioService } from '../../services/destinatario.service';

@Component({
  selector: 'app-destinatario-details',
  templateUrl: './destinatario-details.component.html',
  styleUrls: ['./destinatario-details.component.css']
})
export class DestinatarioDetailsComponent implements OnInit {

  destinatario: Destinatario | undefined;

  constructor(private destinatarioService: DestinatarioService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let ID: number = this.activatedRoute.snapshot.params['ID'];
    this.destinatarioService.getDestinatarioPorNombre(ID).subscribe(destinatarioDatos => (this.destinatario = destinatarioDatos))
  }

}
