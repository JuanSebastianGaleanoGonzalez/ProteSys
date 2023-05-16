import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCasaViewComponent } from './admin-casa-view.component';

describe('AdminCasaViewComponent', () => {
  let component: AdminCasaViewComponent;
  let fixture: ComponentFixture<AdminCasaViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCasaViewComponent]
    });
    fixture = TestBed.createComponent(AdminCasaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
