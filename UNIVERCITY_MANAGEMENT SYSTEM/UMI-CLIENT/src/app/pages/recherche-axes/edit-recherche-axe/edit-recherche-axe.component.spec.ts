import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRechercheAxeComponent } from './edit-recherche-axe.component';

describe('EditRechercheAxeComponent', () => {
  let component: EditRechercheAxeComponent;
  let fixture: ComponentFixture<EditRechercheAxeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditRechercheAxeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditRechercheAxeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
