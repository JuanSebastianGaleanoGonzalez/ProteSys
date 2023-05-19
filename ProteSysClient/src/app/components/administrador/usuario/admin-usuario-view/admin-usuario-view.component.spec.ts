import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsuarioViewComponent } from './admin-usuario-view.component';

describe('AdminUsuarioViewComponent', () => {
  let component: AdminUsuarioViewComponent;
  let fixture: ComponentFixture<AdminUsuarioViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUsuarioViewComponent]
    });
    fixture = TestBed.createComponent(AdminUsuarioViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
