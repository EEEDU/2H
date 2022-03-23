import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { DestinatarioComponent } from './destinatario/destinatario.component';
import { DestinatarioDetailsComponent } from './destinatario/details/destinatario-details/destinatario-details.component';
import { OdsComponent } from './ods/ods.component';
import { PaisComponent } from './pais/pais.component';
import { ProyectoComponent } from './proyecto/proyecto.component';
import { ErrorComponent } from './error/error.component';


import { DestinatarioService } from './destinatario/services/destinatario.service';
import { DestinatarioListaComponent } from './destinatario/destinatario-lista/destinatario-lista.component';
import { OdsListaComponent } from './ods/ods-lista/ods-lista.component';

const appRoutes: Routes = [
	{ path: 'Destinatario', component: DestinatarioComponent },
	{ path: 'Destinatario/:ID', component: DestinatarioDetailsComponent },
	{ path: 'Ods', component: OdsComponent },
	{ path: 'Pais', component: PaisComponent },
	{ path: 'Proyecto', component: ProyectoComponent },
	{ path: '', redirectTo: '/Proyecto', pathMatch: 'full' },
	{ path: '**', component: ErrorComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    DestinatarioComponent,
    OdsComponent,
    PaisComponent,
    ProyectoComponent,
    ErrorComponent,
    DestinatarioDetailsComponent,
    DestinatarioListaComponent,
    OdsListaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    NgbModule,
  ],
  providers: [DestinatarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
