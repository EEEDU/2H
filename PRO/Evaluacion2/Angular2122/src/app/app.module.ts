import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AlumnoComponent } from './Alumno/Alumno.component';
import { AlumnoListaComponent } from './Alumno/AlumnoLista.component';
import { AlumnoTituloPipe } from './Alumno/AlumnoTitulo.pipe';
import { AlumnoCountComponent } from './Alumno/AlumnoCount.component';


@NgModule({
    imports: [BrowserModule],
    declarations: [AppComponent, AlumnoComponent, AlumnoListaComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
