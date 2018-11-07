import { AssegnazionebadgeService } from './../services/assegnazionebadge.service';
import { TestBed, inject } from '@angular/core/testing';


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
