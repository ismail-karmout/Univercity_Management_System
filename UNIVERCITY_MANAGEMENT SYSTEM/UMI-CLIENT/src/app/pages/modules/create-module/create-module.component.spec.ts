import { ComponentFixture, TestBed } from '@angular/core/testing';

import { createModuleComponent } from './create-module.component';

describe('createModuleComponent', () => {
  let component: createModuleComponent;
  let fixture: ComponentFixture<createModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [createModuleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(createModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
