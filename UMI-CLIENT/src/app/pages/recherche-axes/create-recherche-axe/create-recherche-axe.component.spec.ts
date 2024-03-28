import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRechercheAxeComponent } from './create-recherche-axe.component';

describe('CreateRechercheAxeComponent', () => {
  let component: CreateRechercheAxeComponent;
  let fixture: ComponentFixture<CreateRechercheAxeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateRechercheAxeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateRechercheAxeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
