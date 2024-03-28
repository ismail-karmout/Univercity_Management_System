import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPlaningExamComponent } from './edit-planing-exam.component';

describe('EditPlaningExamComponent', () => {
  let component: EditPlaningExamComponent;
  let fixture: ComponentFixture<EditPlaningExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditPlaningExamComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditPlaningExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
