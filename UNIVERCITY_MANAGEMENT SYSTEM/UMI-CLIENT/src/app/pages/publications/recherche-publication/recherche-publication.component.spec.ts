import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecherchePublicationComponent } from './recherche-publication.component';

describe('RecherchePublicationComponent', () => {
  let component: RecherchePublicationComponent;
  let fixture: ComponentFixture<RecherchePublicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RecherchePublicationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecherchePublicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
