import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkLeaveComponent } from './work-leave.component';

describe('WorkLeaveComponent', () => {
  let component: WorkLeaveComponent;
  let fixture: ComponentFixture<WorkLeaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkLeaveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorkLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
