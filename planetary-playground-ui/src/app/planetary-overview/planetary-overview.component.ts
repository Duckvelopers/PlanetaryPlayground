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
  dayDuration: number,
  descripciones: DescripcionesPlaneta,
  haveAtmosphere: boolean,
  imagen: string,
  isSolid: boolean,
  magneticField: number,
  mass: number,
  name: string,
  orbitalPeriod: number,
  pressure: number,
  radius: number,
  starDistance: number,
  surfaceTemperature: number
}

export interface StarObject {
  constanteLuminosidadSol: number,
  constanteRadioSol: number,
  constanteSigma: number,
  descripciones: DescripcionesSol,
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

export interface DescripcionesPlaneta {
  ATMOSFERA: string,
  CAMPOMAGNETICO: string,
  DISTANCIA: string,
  DISTANCIAAESTRELLA: string,
  DURACIONDIA: string,
  GASEOSOONO: string,
  MASA: string,
  NOMBRE: string,
  PERIODOORBITAL: string,
  PRESION: string,
  TAMANHO: string,
  TEMPERATURA: string
}

export interface DescripcionesSol {
}

@Component({
  selector: 'app-planetary-overview',
  templateUrl: './planetary-overview.component.html',
  styleUrls: ['./planetary-overview.component.scss']
})
export class PlanetaryOverviewComponent implements OnInit {
  urlBase: string = 'http://planetplayground-env.wuakashtt6.eu-west-2.elasticbeanstalk.com';

  sequences: Secuencia[];

  currentSun: StarObject;
  currentSunSelected : StarObject;
  currentPlanets: Planet[];
  currentPlanetSelected: Planet;
  selectedCorp: boolean;

  constructor(private _http: HttpClient, protected translate: TranslateService) {
    translate.onLangChange.subscribe(event => {
      this.sequences = [
        { name: translate.instant('STAR_FORM.SEQUENCE.SUPERGIANT'), value: 1 },
        { name: translate.instant('STAR_FORM.SEQUENCE.GIANT'), value: 3 },
        { name: translate.instant('STAR_FORM.SEQUENCE.MAIN_SEQUENCE'), value: 5 }
      ]
    });

    this.selectedCorp = false;
    this.currentSun = undefined;
    this.currentSunSelected = undefined;
    this.currentPlanets = [];
    this.currentPlanetSelected = undefined;
  }

  ngOnInit() {
  }

  starChange(_$event: MatRadioChange) {
    this.selectedCorp = false;
    this.currentSunSelected = undefined;
    this.currentPlanetSelected = undefined;

    if (_$event.value !== "CUSTOM") {
      this.requestCustom(_$event.value);
    }
  }

  sequenceChanged(_$event: MatSelectChange) {
    console.log("Sequence changed works");
  }

  requestCustom(starName: string) {
    const requestedStar = { "SOLAR": `${starName}` };

    this._http.post(this.urlBase + '/star', requestedStar, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: PredefResponse) => {
      console.log(response)

      this.currentSun = response.star
      this.currentPlanets = response.ArrayPlanets;
    });
  }

  currentSunInfo() {
    this.selectedCorp = true;
    this.currentPlanetSelected = undefined;
    this.currentSunSelected = this.currentSun;
  }

  currentPlanetInfo(index) {
    this.selectedCorp = true;
    this.currentSunSelected = undefined;
    this.currentPlanetSelected = this.currentPlanets[index];
  }
}

