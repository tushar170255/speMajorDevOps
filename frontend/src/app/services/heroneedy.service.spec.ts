import { TestBed } from '@angular/core/testing';

import { HeroneedyService } from './heroneedy.service';

describe('HeroneedyService', () => {
  let service: HeroneedyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HeroneedyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
