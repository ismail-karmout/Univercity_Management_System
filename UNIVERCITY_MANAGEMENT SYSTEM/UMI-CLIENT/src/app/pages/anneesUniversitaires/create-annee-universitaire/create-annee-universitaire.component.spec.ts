import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAnneeUniversitaireComponent } from './create-annee-universitaire.component';

describe('CreateAnneeUniversitaireComponent', () => {
  let component: CreateAnneeUniversitaireComponent;
  let fixture: ComponentFixture<CreateAnneeUniversitaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateAnneeUniversitaireComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateAnneeUniversitaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
