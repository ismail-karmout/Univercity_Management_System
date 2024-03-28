import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllNewsComponent } from './get-all-news.component';

describe('GetAllNewsComponent', () => {
  let component: GetAllNewsComponent;
  let fixture: ComponentFixture<GetAllNewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GetAllNewsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GetAllNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
