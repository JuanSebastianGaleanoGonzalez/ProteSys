import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGrupoViewComponent } from './admin-grupo-view.component';

describe('AdminGrupoViewComponent', () => {
  let component: AdminGrupoViewComponent;
  let fixture: ComponentFixture<AdminGrupoViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminGrupoViewComponent]
    });
    fixture = TestBed.createComponent(AdminGrupoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
