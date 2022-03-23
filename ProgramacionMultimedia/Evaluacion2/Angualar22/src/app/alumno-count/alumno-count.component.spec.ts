import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumnoCountComponent } from './alumno-count.component';

describe('AlumnoCountComponent', () => {
  let component: AlumnoCountComponent;
  let fixture: ComponentFixture<AlumnoCountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlumnoCountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlumnoCountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
