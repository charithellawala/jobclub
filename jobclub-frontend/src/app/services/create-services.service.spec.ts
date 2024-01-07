import { TestBed } from '@angular/core/testing';

import { CreateServices } from './create-services';

describe('CreateServicesService', () => {
  let service: CreateServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
