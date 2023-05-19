import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCasaUpdateComponent } from './admin-casa-update.component';

describe('AdminCasaUpdateComponent', () => {
  let component: AdminCasaUpdateComponent;
  let fixture: ComponentFixture<AdminCasaUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCasaUpdateComponent]
    });
    fixture = TestBed.createComponent(AdminCasaUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
