import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AlumnoComponent } from './alumno/alumno.component';
import { AlumnoListaComponent } from './alumno-lista/alumno-lista.component';
import { AlumnoTituloPipe } from './alumno-titulo.pipe';
import { AlumnoCountComponent } from './alumno-count/alumno-count.component';
import { ProfesorComponent } from './profesor/profesor.component';
import { ErrorComponent } from './error/error.component';

import { AlumnoService } from './services/alumno.service';
import { ClaseComponent } from './clase/clase.component'

const appRoutes: Routes = [
	{ path: 'Alumno', component: AlumnoListaComponent },
	{ path: 'Alumno/:nombre', component: AlumnoComponent },
	{ path: 'Profesor', component: ProfesorComponent },
	{ path: 'Clase', component: ProfesorComponent },
	{ path: '', redirectTo: '/profesor', pathMatch: 'full' },
	{ path: '**', component: ErrorComponent},
]

@NgModule({
	declarations: [
		AppComponent,
		AlumnoComponent,
		AlumnoListaComponent,
		AlumnoTituloPipe,
		AlumnoCountComponent,
		ProfesorComponent,
		ErrorComponent,
  		ClaseComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		FormsModule, 
		HttpClientModule,
		RouterModule.forRoot(appRoutes),
	],
	providers: [AlumnoService],
	bootstrap: [AppComponent]
})
export class AppModule { }
