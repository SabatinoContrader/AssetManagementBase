/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BadgereaderService } from './badgereader.service';

describe('Service: Badgereader', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BadgereaderService]
    });
  });

  it('should ...', inject([BadgereaderService], (service: BadgereaderService) => {
    expect(service).toBeTruthy();
  }));
});
