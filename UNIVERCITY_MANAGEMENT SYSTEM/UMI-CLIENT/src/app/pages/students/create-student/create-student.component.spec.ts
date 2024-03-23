import { ComponentFixture, TestBed } from '@angular/core/testing';

import { createStudentComponent } from './create-student.component';

describe('createStudentComponent', () => {
  let component: createStudentComponent;
  let fixture: ComponentFixture<createStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [createStudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(createStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
