import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsuarioUpdateComponent } from './admin-usuario-update.component';

describe('AdminUsuarioUpdateComponent', () => {
  let component: AdminUsuarioUpdateComponent;
  let fixture: ComponentFixture<AdminUsuarioUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUsuarioUpdateComponent]
    });
    fixture = TestBed.createComponent(AdminUsuarioUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
