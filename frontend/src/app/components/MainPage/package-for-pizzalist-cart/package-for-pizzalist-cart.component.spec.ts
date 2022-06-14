import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageForPizzalistCartComponent } from './package-for-pizzalist-cart.component';

describe('PackageForPizzalistCartComponent', () => {
  let component: PackageForPizzalistCartComponent;
  let fixture: ComponentFixture<PackageForPizzalistCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PackageForPizzalistCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageForPizzalistCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
