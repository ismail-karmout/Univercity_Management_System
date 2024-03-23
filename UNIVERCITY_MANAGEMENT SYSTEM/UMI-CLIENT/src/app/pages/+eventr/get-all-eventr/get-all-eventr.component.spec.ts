import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllEventrComponent } from './get-all-eventr.component';

describe('GetAllEventrComponent', () => {
  let component: GetAllEventrComponent;
  let fixture: ComponentFixture<GetAllEventrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GetAllEventrComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GetAllEventrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
