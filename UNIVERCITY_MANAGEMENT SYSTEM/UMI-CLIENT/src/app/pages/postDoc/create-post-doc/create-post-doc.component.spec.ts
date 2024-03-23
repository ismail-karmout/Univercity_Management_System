import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePostDocComponent } from './create-post-doc.component';

describe('CreatePostDocComponent', () => {
  let component: CreatePostDocComponent;
  let fixture: ComponentFixture<CreatePostDocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreatePostDocComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreatePostDocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
