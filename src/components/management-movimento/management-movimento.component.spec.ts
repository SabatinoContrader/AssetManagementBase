import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementMovimentoComponent } from './management-movimento.component';

describe('ManagementMovimentoComponent', () => {
  let component: ManagementMovimentoComponent;
  let fixture: ComponentFixture<ManagementMovimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementMovimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementMovimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
