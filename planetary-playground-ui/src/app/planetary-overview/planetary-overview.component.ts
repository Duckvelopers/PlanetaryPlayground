import { Component, OnInit } from '@angular/core';
import { MatRadioChange } from '@angular/material/radio';
import { HttpClient } from '@angular/common/http';
import { TranslateService } from '@ngx-translate/core';
import { MatSelectChange } from '@angular/material/select';

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

export interface Secuencia {
  name: string
  value: number
}

@Component({
  selector: 'app-planetary-overview',
  templateUrl: './planetary-overview.component.html',
  styleUrls: ['./planetary-overview.component.scss']
})
export class PlanetaryOverviewComponent implements OnInit {
  urlBase: string = 'http://planetplayground-env.wuakashtt6.eu-west-2.elasticbeanstalk.com';

  sequences: Secuencia[];

  constructor(private _http: HttpClient, protected translate: TranslateService) {
    translate.onLangChange.subscribe(event => {
      this.sequences = [
        { name: translate.instant('STAR_FORM.SEQUENCE.SUPERGIANT'), value: 1 },
        { name: translate.instant('STAR_FORM.SEQUENCE.GIANT'), value: 3 },
        { name: translate.instant('STAR_FORM.SEQUENCE.MAIN_SEQUENCE'), value: 5 },
        { name: translate.instant('STAR_FORM.SEQUENCE.WHITE_DWARF'), value: 7 },
      ]
    });
  }

  ngOnInit() {
  }

  starChange(_$event: MatRadioChange) {
    if (_$event.value !== "CUSTOM") {
      this.requestCustom(_$event.value);
    }
  }

  sequenceChanged(_$event: MatSelectChange){

  }

  setSequence(){
    
  }

  requestCustom(starName: string) {
    const requestedStar = { "SOLAR": `${starName}` };

    this._http.post(this.urlBase + '/star', requestedStar, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: PredefResponse) => {
      console.log(starName, response.star)
    });
  }
}
