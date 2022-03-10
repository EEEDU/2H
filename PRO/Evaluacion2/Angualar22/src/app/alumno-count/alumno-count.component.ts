import { Component, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-alumno-count',
  templateUrl: './alumno-count.component.html',
  styleUrls: ['./alumno-count.component.css']
})
export class AlumnoCountComponent {

  opcionElegida: string = 'Todos';

  @Output() 
  globalElegido: EventEmitter<string> = new EventEmitter<string>();

  @Input() todos: number = 0;

  @Input()
  hombres: number = 0;
  
  @Input()
  mujeres: number = 0;

  cambiar() {
    this.globalElegido.emit(this.opcionElegida)
  }
}
 