import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DestinatarioDetailsComponent } from './destinatario-details.component';

describe('DestinatarioDetailsComponent', () => {
  let component: DestinatarioDetailsComponent;
  let fixture: ComponentFixture<DestinatarioDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DestinatarioDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DestinatarioDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
