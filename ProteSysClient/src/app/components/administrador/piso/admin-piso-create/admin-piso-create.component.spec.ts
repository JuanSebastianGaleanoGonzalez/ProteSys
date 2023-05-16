import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPisoCreateComponent } from './admin-piso-create.component';

describe('AdminPisoCreateComponent', () => {
  let component: AdminPisoCreateComponent;
  let fixture: ComponentFixture<AdminPisoCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminPisoCreateComponent]
    });
    fixture = TestBed.createComponent(AdminPisoCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
