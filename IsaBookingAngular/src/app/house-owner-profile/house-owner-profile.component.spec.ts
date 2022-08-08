import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HouseOwnerProfileComponent } from './house-owner-profile.component';

describe('HouseOwnerProfileComponent', () => {
  let component: HouseOwnerProfileComponent;
  let fixture: ComponentFixture<HouseOwnerProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HouseOwnerProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HouseOwnerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
