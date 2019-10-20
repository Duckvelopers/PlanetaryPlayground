import { Component, OnInit } from '@angular/core';
import { MatRadioChange } from '@angular/material/radio';
import { HttpClient } from '@angular/common/http';
import { TranslateService } from '@ngx-translate/core';
import { MatSelectChange } from '@angular/material/select';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

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
  radio: number,
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
  classifications: string[];

  currentSun: StarObject;
  currentSunSelected: StarObject;
  currentPlanets: Planet[];
  currentPlanetSelected: Planet;
  selectedCorp: boolean;

  sequenceControl = new FormControl('');
  classificationControl = new FormControl('');
  displayRepresentation: boolean;

  constructor(private _http: HttpClient, protected translate: TranslateService) {
    translate.onLangChange.subscribe(event => {
      this.sequences = [
        { name: translate.instant('STAR_FORM.SEQUENCE.SUPERGIANT'), value: 1 },
        { name: translate.instant('STAR_FORM.SEQUENCE.GIANT'), value: 3 },
        { name: translate.instant('STAR_FORM.SEQUENCE.MAIN_SEQUENCE'), value: 5 }
      ]
    });
    this.classifications = [];

    this.selectedCorp = false;
    this.currentSun = undefined;
    this.currentSunSelected = undefined;
    this.currentPlanets = [];
    this.currentPlanetSelected = undefined;

    this.sequenceControl.disable();
    this.classificationControl.disable();
  }

  ngOnInit() {
  }

  starChange(_$event: MatRadioChange) {
    this.displayRepresentation = false;
    this.selectedCorp = false;
    this.currentSunSelected = undefined;
    this.currentPlanetSelected = undefined;

    if (_$event.value !== "CUSTOM") {
      this.sequenceControl.disable();
      this.sequenceControl.reset();
      this.classificationControl.disable();
      this.classificationControl.reset();
      this.requestCustom(_$event.value);
    } else {
      this.sequenceControl.enable();
    }
  }

  sequenceChanged(_$event: MatSelectChange) {
    const requestedSequence = { "SEQUENCE": `${_$event.value}` };

    this._http.post(this.urlBase + '/secuencia', requestedSequence, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: string[]) => {
      this.classificationControl.reset();
      this.classifications = response;
      this.classificationControl.enable();
    });
  }

  classifChanged(_$event) {
    const requestedSequence = { "SEQUENCE": `${this.sequenceControl.value}`, "CLASS": `${_$event.value}` };

    this._http.post(this.urlBase + '/espectral', requestedSequence, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: string[]) => {
      console.log(response);
    });
  }

  requestCustom(starName: string) {
    const requestedStar = { "SOLAR": `${starName}` };

    this._http.post(this.urlBase + '/star', requestedStar, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: PredefResponse) => {
      this.currentSun = response.star
      this.currentPlanets = response.ArrayPlanets;
      this.displayRepresentation = true;
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

  getSequenceTranslation(sequence) {
    let translation = "";
    switch (sequence) {
      case 1:
        translation = this.translate.instant('STAR_FORM.SEQUENCE.SUPERGIANT');
        break;
      case 2:
        break;
      case 3:
        translation = this.translate.instant('STAR_FORM.SEQUENCE.GIANT');
        break;
      case 4:
        break;
      case 5:
        translation = this.translate.instant('STAR_FORM.SEQUENCE.MAIN_SEQUENCE');
        break;
    }
    return translation;
  }
}

