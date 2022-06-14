import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopBarRegisterComponent } from './top-bar-register.component';

describe('TopBarRegisterComponent', () => {
  let component: TopBarRegisterComponent;
  let fixture: ComponentFixture<TopBarRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopBarRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopBarRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
