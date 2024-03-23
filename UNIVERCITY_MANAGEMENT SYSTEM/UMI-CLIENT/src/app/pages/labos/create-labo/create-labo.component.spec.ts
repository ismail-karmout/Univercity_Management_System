import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLaboComponent } from './create-labo.component';

describe('CreateLaboComponent', () => {
  let component: CreateLaboComponent;
  let fixture: ComponentFixture<CreateLaboComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateLaboComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CreateLaboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
