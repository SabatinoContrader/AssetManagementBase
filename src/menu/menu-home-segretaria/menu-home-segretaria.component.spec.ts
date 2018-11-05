import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuHomeSegretariaComponent } from './menu-home-segretaria.component';

describe('MenuHomeSegretariaComponent', () => {
  let component: MenuHomeSegretariaComponent;
  let fixture: ComponentFixture<MenuHomeSegretariaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuHomeSegretariaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuHomeSegretariaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
