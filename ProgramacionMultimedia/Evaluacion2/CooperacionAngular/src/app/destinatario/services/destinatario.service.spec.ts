import { TestBed } from '@angular/core/testing';

import { DestinatarioService } from './destinatario.service';

describe('DestinatarioService', () => {
  let service: DestinatarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DestinatarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
