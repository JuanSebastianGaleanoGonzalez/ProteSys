import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPisoUpdateComponent } from './admin-piso-update.component';

describe('AdminPisoUpdateComponent', () => {
  let component: AdminPisoUpdateComponent;
  let fixture: ComponentFixture<AdminPisoUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminPisoUpdateComponent]
    });
    fixture = TestBed.createComponent(AdminPisoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
