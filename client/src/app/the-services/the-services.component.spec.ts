import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TheServicesComponent } from './the-services.component';

describe('TheServicesComponent', () => {
  let component: TheServicesComponent;
  let fixture: ComponentFixture<TheServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TheServicesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TheServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
