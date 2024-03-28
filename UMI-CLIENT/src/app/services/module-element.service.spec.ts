import { TestBed } from '@angular/core/testing';

import { ModuleElementService } from './module-element.service';

describe('ModuleElementService', () => {
  let service: ModuleElementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModuleElementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
