import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumnoListaComponent } from './alumno-lista.component';

describe('AlumnoListaComponent', () => {
  let component: AlumnoListaComponent;
  let fixture: ComponentFixture<AlumnoListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlumnoListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlumnoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
