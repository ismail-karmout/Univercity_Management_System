import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEcoleDoctoraleComponent } from './create-ecole-doctorale.component';

describe('CreateEcoleDoctoraleComponent', () => {
  let component: CreateEcoleDoctoraleComponent;
  let fixture: ComponentFixture<CreateEcoleDoctoraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateEcoleDoctoraleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateEcoleDoctoraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
