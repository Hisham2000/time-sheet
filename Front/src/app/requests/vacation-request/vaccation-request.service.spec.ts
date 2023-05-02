import { TestBed } from '@angular/core/testing';

import { VaccationRequestService } from './vaccation-request.service';

describe('VaccationRequestService', () => {
  let service: VaccationRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccationRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
