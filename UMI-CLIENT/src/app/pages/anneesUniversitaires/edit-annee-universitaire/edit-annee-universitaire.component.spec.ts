import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAnneeUniversitaireComponent } from './edit-annee-universitaire.component';

describe('EditAnneeUniversitaireComponent', () => {
  let component: EditAnneeUniversitaireComponent;
  let fixture: ComponentFixture<EditAnneeUniversitaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditAnneeUniversitaireComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditAnneeUniversitaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
