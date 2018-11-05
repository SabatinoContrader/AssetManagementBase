import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeSegretariaComponent } from './home-segretaria.component';

describe('HomeSegretariaComponent', () => {
  let component: HomeSegretariaComponent;
  let fixture: ComponentFixture<HomeSegretariaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeSegretariaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeSegretariaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
