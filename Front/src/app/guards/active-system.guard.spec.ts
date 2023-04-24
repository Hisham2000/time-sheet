import { TestBed } from '@angular/core/testing';

import { ActiveSystemGuard } from './active-system.guard';

describe('ActiveSystemGuard', () => {
  let guard: ActiveSystemGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ActiveSystemGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
