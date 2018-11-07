import { TestBed, inject } from '@angular/core/testing';

import { AssegnazionebadgeService } from './assegnazionebadge.service';

describe('AssegnazionebadgeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssegnazionebadgeService]
    });
  });

  it('should be created', inject([AssegnazionebadgeService], (service: AssegnazionebadgeService) => {
    expect(service).toBeTruthy();
  }));
});
