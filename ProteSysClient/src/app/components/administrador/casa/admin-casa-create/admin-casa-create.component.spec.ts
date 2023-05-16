import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCasaCreateComponent } from './admin-casa-create.component';

describe('AdminCasaCreateComponent', () => {
  let component: AdminCasaCreateComponent;
  let fixture: ComponentFixture<AdminCasaCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCasaCreateComponent]
    });
    fixture = TestBed.createComponent(AdminCasaCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
