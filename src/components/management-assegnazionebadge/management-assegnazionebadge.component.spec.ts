import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementAssegnazionebadgeComponent } from './management-assegnazionebadge.component';

describe('ManagementAssegnazionebadgeComponent', () => {
  let component: ManagementAssegnazionebadgeComponent;
  let fixture: ComponentFixture<ManagementAssegnazionebadgeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementAssegnazionebadgeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementAssegnazionebadgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
