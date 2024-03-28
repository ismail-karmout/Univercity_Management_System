import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPhdStudentComponent } from './edit-phd-student.component';

describe('EditPhdStudentComponent', () => {
  let component: EditPhdStudentComponent;
  let fixture: ComponentFixture<EditPhdStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditPhdStudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditPhdStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
