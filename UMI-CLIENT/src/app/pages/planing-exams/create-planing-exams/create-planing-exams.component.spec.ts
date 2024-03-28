import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePlaningExamsComponent } from './create-planing-exams.component';

describe('CreatePlaningExamsComponent', () => {
  let component: CreatePlaningExamsComponent;
  let fixture: ComponentFixture<CreatePlaningExamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreatePlaningExamsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreatePlaningExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
