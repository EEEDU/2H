import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DestinatarioListaComponent } from './destinatario-lista.component';

describe('DestinatarioListaComponent', () => {
  let component: DestinatarioListaComponent;
  let fixture: ComponentFixture<DestinatarioListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DestinatarioListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DestinatarioListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
