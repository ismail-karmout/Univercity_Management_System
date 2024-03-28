import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhdStudentsComponent } from './phd-students.component';

describe('PhdStudentsComponent', () => {
  let component: PhdStudentsComponent;
  let fixture: ComponentFixture<PhdStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PhdStudentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PhdStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
