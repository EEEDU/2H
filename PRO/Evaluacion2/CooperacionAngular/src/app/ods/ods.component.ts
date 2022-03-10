import { Component, OnInit } from '@angular/core';
import { OdsService } from './services/ods.service';
import { Ods } from './interface/ods';

@Component({
  selector: 'app-ods',
  templateUrl: './ods.component.html',
  styleUrls: ['./ods.component.css']
})

export class OdsComponent implements OnInit {

  ods: Ods[] = [];

  constructor(public odsService: OdsService) { }

  ngOnInit(): void {
    this.odsService.getOds().subscribe(datosOds => (this.ods = datosOds));
  }

}
