import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuBookingComponent } from './menu-booking.component';

describe('MenuBookingComponent', () => {
  let component: MenuBookingComponent;
  let fixture: ComponentFixture<MenuBookingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuBookingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
