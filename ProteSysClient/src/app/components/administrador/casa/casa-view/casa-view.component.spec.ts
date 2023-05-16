import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasaViewComponent } from './casa-view.component';

describe('CasaViewComponent', () => {
  let component: CasaViewComponent;
  let fixture: ComponentFixture<CasaViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CasaViewComponent]
    });
    fixture = TestBed.createComponent(CasaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
