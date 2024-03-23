import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditEcoleDoctoraleComponent } from './edit-ecole-doctorale.component';

describe('EditEcoleDoctoraleComponent', () => {
  let component: EditEcoleDoctoraleComponent;
  let fixture: ComponentFixture<EditEcoleDoctoraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditEcoleDoctoraleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditEcoleDoctoraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
