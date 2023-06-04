import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoGrupoComponent } from './info-grupo.component';

describe('InfoGrupoComponent', () => {
  let component: InfoGrupoComponent;
  let fixture: ComponentFixture<InfoGrupoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InfoGrupoComponent]
    });
    fixture = TestBed.createComponent(InfoGrupoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
