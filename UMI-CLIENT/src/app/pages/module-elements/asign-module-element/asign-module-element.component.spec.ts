import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignModuleElementComponent } from './asign-module-element.component';

describe('AsignModuleElementComponent', () => {
  let component: AsignModuleElementComponent;
  let fixture: ComponentFixture<AsignModuleElementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AsignModuleElementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AsignModuleElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
