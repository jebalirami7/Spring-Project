import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Interface1Component } from './interface1.component';

describe('Interface1Component', () => {
  let component: Interface1Component;
  let fixture: ComponentFixture<Interface1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Interface1Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Interface1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
