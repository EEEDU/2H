import { TestBed } from '@angular/core/testing';

import { OdsService } from './ods.service';

describe('OdsService', () => {
  let service: OdsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OdsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
