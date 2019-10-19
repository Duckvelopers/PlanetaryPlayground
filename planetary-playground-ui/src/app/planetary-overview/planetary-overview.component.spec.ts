import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetaryOverviewComponent } from './planetary-overview.component';

describe('PlanetaryOverviewComponent', () => {
  let component: PlanetaryOverviewComponent;
  let fixture: ComponentFixture<PlanetaryOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanetaryOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanetaryOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
