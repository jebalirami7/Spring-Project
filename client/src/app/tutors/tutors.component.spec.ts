import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorsComponent } from './tutors.component';

describe('TutorsComponent', () => {
  let component: TutorsComponent;
  let fixture: ComponentFixture<TutorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TutorsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TutorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
