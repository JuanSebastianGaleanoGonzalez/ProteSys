import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsuarioCreateComponent } from './admin-usuario-create.component';

describe('AdminUsuarioCreateComponent', () => {
  let component: AdminUsuarioCreateComponent;
  let fixture: ComponentFixture<AdminUsuarioCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUsuarioCreateComponent]
    });
    fixture = TestBed.createComponent(AdminUsuarioCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
