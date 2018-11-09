import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementExportComponent } from './management-export.component';

describe('ManagementExportComponent', () => {
  let component: ManagementExportComponent;
  let fixture: ComponentFixture<ManagementExportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementExportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementExportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
