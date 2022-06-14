import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopBarEditComponent } from './top-bar-edit.component';

describe('TopBarEditComponent', () => {
  let component: TopBarEditComponent;
  let fixture: ComponentFixture<TopBarEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopBarEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopBarEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
