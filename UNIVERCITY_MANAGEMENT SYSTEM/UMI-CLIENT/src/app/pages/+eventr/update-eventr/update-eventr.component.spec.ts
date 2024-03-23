import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEventrComponent } from './update-eventr.component';

describe('UpdateEventrComponent', () => {
  let component: UpdateEventrComponent;
  let fixture: ComponentFixture<UpdateEventrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateEventrComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateEventrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
