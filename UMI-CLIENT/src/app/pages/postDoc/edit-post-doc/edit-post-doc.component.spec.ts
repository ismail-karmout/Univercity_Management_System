import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPostDocComponent } from './edit-post-doc.component';

describe('EditPostDocComponent', () => {
  let component: EditPostDocComponent;
  let fixture: ComponentFixture<EditPostDocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditPostDocComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditPostDocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
