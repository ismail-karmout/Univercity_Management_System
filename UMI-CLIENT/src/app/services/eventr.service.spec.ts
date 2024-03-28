import { TestBed } from '@angular/core/testing';

import { EventrService } from './eventr.service';

describe('EventrService', () => {
  let service: EventrService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventrService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
