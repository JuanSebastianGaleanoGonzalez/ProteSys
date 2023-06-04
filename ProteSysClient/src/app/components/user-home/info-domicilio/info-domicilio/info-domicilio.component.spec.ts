import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoDomicilioComponent } from './info-domicilio.component';

describe('InfoDomicilioComponent', () => {
  let component: InfoDomicilioComponent;
  let fixture: ComponentFixture<InfoDomicilioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InfoDomicilioComponent]
    });
    fixture = TestBed.createComponent(InfoDomicilioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
