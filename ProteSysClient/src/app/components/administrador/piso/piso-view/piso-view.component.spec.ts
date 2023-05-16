import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PisoViewComponent } from './piso-view.component';

describe('PisoViewComponent', () => {
  let component: PisoViewComponent;
  let fixture: ComponentFixture<PisoViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PisoViewComponent]
    });
    fixture = TestBed.createComponent(PisoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
