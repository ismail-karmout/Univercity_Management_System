import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEventrComponent } from './create-eventr.component';

describe('CreateEventrComponent', () => {
  let component: CreateEventrComponent;
  let fixture: ComponentFixture<CreateEventrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateEventrComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateEventrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
