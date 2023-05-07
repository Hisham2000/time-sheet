import { TestBed } from '@angular/core/testing';

import { IsHrGuard } from './is-hr.guard';

describe('IsHrGuard', () => {
  let guard: IsHrGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsHrGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
