import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OdsListaComponent } from './ods-lista.component';

describe('OdsListaComponent', () => {
  let component: OdsListaComponent;
  let fixture: ComponentFixture<OdsListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OdsListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OdsListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
