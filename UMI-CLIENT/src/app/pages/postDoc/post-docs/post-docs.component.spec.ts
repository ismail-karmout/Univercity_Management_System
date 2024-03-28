import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostDocsComponent } from './post-docs.component';

describe('PostDocsComponent', () => {
  let component: PostDocsComponent;
  let fixture: ComponentFixture<PostDocsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PostDocsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PostDocsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
