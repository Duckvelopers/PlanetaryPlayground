import { Component, OnInit } from '@angular/core';
import { MatRadioChange } from '@angular/material/radio';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

export interface PredefResponse {
  ArrayPlanets: Planet[];
  star: StarObject;
}

export interface Planet {
  haveAtmosphere: boolean,
  isSolid: boolean,
  mass: number,
  name: string,
  numberOfSatellites: number,
  pressure: number,
  radius: number,
  temperature: number
}

export interface StarObject {
  constanteLuminosidadSol: number,
  constanteRadioSol: number,
  constanteSigma: number,
  luminosidad: number,
  magnitudAbsoluta: number,
  masa: number,
  radio: number
  secuencia: number,
  temperatura: number,
  tipoEspectral: string
}

@Component({
  selector: 'app-planetary-overview',
  templateUrl: './planetary-overview.component.html',
  styleUrls: ['./planetary-overview.component.scss']
})
export class PlanetaryOverviewComponent implements OnInit {
  urlBase: string = 'http://planetplayground-env.wuakashtt6.eu-west-2.elasticbeanstalk.com';

  constructor(private _http: HttpClient) {

  }

  ngOnInit() {
  }

  starChange(_$event: MatRadioChange) {
    if (_$event.value !== "CUSTOM") {
      this.requestCustom(_$event.value);
    }
  }

  requestCustom(starName: string) {
    const requestedStar = { "SOLAR": `${starName}` };

    this._http.post(this.urlBase + '/star', requestedStar, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: PredefResponse) => {
      console.log(starName, response.ArrayPlanets)
    });
  }
}
