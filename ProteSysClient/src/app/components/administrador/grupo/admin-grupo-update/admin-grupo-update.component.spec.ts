import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGrupoUpdateComponent } from './admin-grupo-update.component';

describe('AdminGrupoUpdateComponent', () => {
  let component: AdminGrupoUpdateComponent;
  let fixture: ComponentFixture<AdminGrupoUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminGrupoUpdateComponent]
    });
    fixture = TestBed.createComponent(AdminGrupoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
