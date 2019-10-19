import { Component, OnInit } from '@angular/core';

export interface Sequence {
  name: string;
  identificator: number;
}

@Component({
  selector: 'app-planetary-overview',
  templateUrl: './planetary-overview.component.html',
  styleUrls: ['./planetary-overview.component.scss']
})
export class PlanetaryOverviewComponent implements OnInit {

  sequences: Sequence[] = [
    {name: 'Supergiant', identificator: 1},
    {name: 'Giant', identificator: 3},
    {name: 'Main Sequence', identificator: 5},
    {name: 'White Dwarf', identificator: 7}
  ];

  constructor() {

  }

  ngOnInit() {
  }

}
