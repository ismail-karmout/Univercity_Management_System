import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSemestreComponent } from './edit-semestre.component';

describe('EditSemestreComponent', () => {
  let component: EditSemestreComponent;
  let fixture: ComponentFixture<EditSemestreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditSemestreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditSemestreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
