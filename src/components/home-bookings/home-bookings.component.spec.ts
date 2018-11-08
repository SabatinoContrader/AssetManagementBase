import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeBookingsComponent } from './home-bookings.component';

describe('HomeBookingsComponent', () => {
  let component: HomeBookingsComponent;
  let fixture: ComponentFixture<HomeBookingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeBookingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeBookingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
