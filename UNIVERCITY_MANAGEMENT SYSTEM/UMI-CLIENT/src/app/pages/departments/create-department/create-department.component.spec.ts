import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEtablissementComponent } from './create-department.component';

describe('CreateEtablissementComponent', () => {
  let component: CreateEtablissementComponent;
  let fixture: ComponentFixture<CreateEtablissementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateEtablissementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateEtablissementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
