import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PisoUpdateComponent } from './piso-update.component';

describe('PisoUpdateComponent', () => {
  let component: PisoUpdateComponent;
  let fixture: ComponentFixture<PisoUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PisoUpdateComponent]
    });
    fixture = TestBed.createComponent(PisoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
