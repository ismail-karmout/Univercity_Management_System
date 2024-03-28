import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheAxesComponent } from './recherche-axes.component';

describe('RechercheAxesComponent', () => {
  let component: RechercheAxesComponent;
  let fixture: ComponentFixture<RechercheAxesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RechercheAxesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RechercheAxesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
