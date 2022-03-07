import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <!-- EJERCICIO 1
       <div>
      <h1>{{encabezado ? getNombreComplete() : "No encontrado"}}</h1>
      <img src='{{imagen}}'>
      <app-alumno></app-alumno>
      <button [disabled] = 'desactivado'>Pulsa aqui</button>
    </div> -->

    <!-- EJERCICIO 2 
    <br><br>
    <button class="color italica negrita" [class.negrita]='!aplicarNegrita'>Boton 2</button> 
    <br><br>
    <button [ngClass]='addClases()'>Boton 3</button> -->

    <!-- EJERCICIO 3 
    <button on-click="onClick()">Boton 1</button>
    <br>
    <img src='https://i.pinimg.com/originals/bb/20/dd/bb20ddbeb9423e07a5768c6623058d12.png' *ngIf='visible'> -->

    <app-alumno></app-alumno>
    <app-alumno-lista></app-alumno-lista>
  `,
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  // EJERCICIO 1
  // encabezado: string = "esta";
  // imagen: string = 'https://logorealm.com/wp-content/uploads/2017/05/nasa-logo.jpg';
  // desactivado: boolean = false;

  // nombre: string = 'Perico';
  // apellido: string = 'Delgado';

  // getNombreComplete(): string {
  //   return this.nombre + ' ' + this.apellido;

  // EJERCICIO 2
  // aplicarClases: string = "italica negrita"
  // aplicarNegrita: boolean = true;
  // aplicarColor: boolean = true;

  // addClases() {
  //   let clases = {
  //     negrita: this.aplicarNegrita,
  //     color: this.aplicarColor
  //   }
  //   return clases;
  // }

  visible: boolean = true;

  onClick(): void{
    this.visible = !this.visible;
  }
}
