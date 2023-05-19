import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGrupoCreateComponent } from './admin-grupo-create.component';

describe('AdminGrupoCreateComponent', () => {
  let component: AdminGrupoCreateComponent;
  let fixture: ComponentFixture<AdminGrupoCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminGrupoCreateComponent]
    });
    fixture = TestBed.createComponent(AdminGrupoCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
