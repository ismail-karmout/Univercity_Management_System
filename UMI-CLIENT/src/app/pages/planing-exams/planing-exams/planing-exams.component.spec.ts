import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaningExamsComponent } from './planing-exams.component';

describe('PlaningExamsComponent', () => {
  let component: PlaningExamsComponent;
  let fixture: ComponentFixture<PlaningExamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PlaningExamsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlaningExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
