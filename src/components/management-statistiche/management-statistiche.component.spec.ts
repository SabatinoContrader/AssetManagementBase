import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementStatisticheComponent } from './management-statistiche.component';

describe('ManagementStatisticheComponent', () => {
  let component: ManagementStatisticheComponent;
  let fixture: ComponentFixture<ManagementStatisticheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementStatisticheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementStatisticheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
