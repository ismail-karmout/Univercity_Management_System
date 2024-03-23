import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePhdStudentComponent } from './create-phd-student.component';

describe('CreatePhdStudentComponent', () => {
  let component: CreatePhdStudentComponent;
  let fixture: ComponentFixture<CreatePhdStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreatePhdStudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreatePhdStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
