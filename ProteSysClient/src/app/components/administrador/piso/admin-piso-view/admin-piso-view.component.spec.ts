import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPisoViewComponent } from './admin-piso-view.component';

describe('AdminPisoViewComponent', () => {
  let component: AdminPisoViewComponent;
  let fixture: ComponentFixture<AdminPisoViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminPisoViewComponent]
    });
    fixture = TestBed.createComponent(AdminPisoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
