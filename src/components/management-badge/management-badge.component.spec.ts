import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementBadgeComponent } from './management-badge.component';

describe('ManagementBadgeComponent', () => {
  let component: ManagementBadgeComponent;
  let fixture: ComponentFixture<ManagementBadgeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementBadgeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementBadgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
