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
  imagen: string,
  descripciones: DescripcionesSol,
  luminosidad: number,
  magnitudAbsoluta: number,
  masa: number,
  name: string,
  radio: number,
  secuencia: number,
  temperatura: number,
  tipoEspectral: string
}

export interface Secuencia {
  name: string
  value: number
}

export interface DescripcionesPlaneta extends Map<unknown, unknown> {
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

export interface DescripcionesSol extends Map<unknown, unknown> {
  CLASS: string,
  SEQUENCE: string
}

@Component({
  selector: 'app-planetary-overview',
  templateUrl: './planetary-overview.component.html',
  styleUrls: ['./planetary-overview.component.scss']
})
export class PlanetaryOverviewComponent implements OnInit {
  urlBase: string = 'https://planetary-playground-service.herokuapp.com';

  sequences: Secuencia[];
  buttonDisabled: boolean;
  classifications: string[];
  radiusSliderValue: number;
  minRadius: number;
  maxRadius: number;
  massSliderValue: number;
  minMass: number;
  maxMass: number;

  currentSun: StarObject;
  currentSunSelected: StarObject;
  currentPlanets: Planet[];
  currentPlanetSelected: Planet;
  selectedCorp: boolean;

  sequenceControl = new FormControl('');
  classificationControl = new FormControl('');
  massSlider = new FormControl('');
  radiusSlider = new FormControl('');
  slidersRadios = new FormControl('');
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

    this.disableAndResetAllControls();
  }

  ngOnInit() {
  }

  starChange(_$event: MatRadioChange) {
    this.displayRepresentation = false;
    this.selectedCorp = false;
    this.currentSunSelected = undefined;
    this.currentPlanetSelected = undefined;
    this.disableAndResetAllControls();

    if (_$event.value !== "CUSTOM") {
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
      this.slidersRadios.disable();
      this.slidersRadios.reset();
      this.radiusSlider.disable();
      this.radiusSlider.reset();
      this.massSlider.disable();
      this.massSlider.reset();
      this.classificationControl.reset();
      this.classifications = response;
      this.classificationControl.enable();
      this.buttonDisabled = true;
    });
  }

  classifChanged(_$event) {
    const requestedSequence = { "SEQUENCE": `${this.sequenceControl.value}`, "CLASS": `${_$event.value}` };

    this._http.post(this.urlBase + '/espectral', requestedSequence, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: number[]) => {
      this.radiusSliderValue = undefined;
      this.massSliderValue = undefined;
      this.radiusSlider.reset();
      this.radiusSlider.disable();
      this.massSlider.reset();
      this.massSlider.disable();
      this.slidersRadios.reset();
      this.slidersRadios.enable();
      this.buttonDisabled = true;

      this.radiusSlider.setValue(response[0]);
      this.radiusSliderValue = Math.round(response[0] * 10) / 10;;
      this.minRadius = response[0];
      this.maxRadius = response[1];
      this.massSlider.setValue(response[2]);
      this.massSliderValue = Math.round(response[2] * 10) / 10;
      this.minMass = response[2];
      this.maxMass = response[3];
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

  formatRadius(value: number) {
    return `${value}R\u2609`;
  }

  formatMass(value: number) {
    return `${value}M\u2609`;
  }

  radiusSliderChange(_$event) {
    this.radiusSliderValue = _$event.value;
  }

  massSliderChange(_$event) {
    this.massSliderValue = _$event.value;
  }

  radiusMassChange(_$event) {
    const selectedRadio = _$event.value;

    if (selectedRadio === "RADIUS") {
      this.massSlider.disable();
      this.radiusSlider.enable();

      this.buttonDisabled = false;
    } else {
      this.radiusSlider.disable();
      this.massSlider.enable();

      this.buttonDisabled = false;
    }
  }

  disableAndResetAllControls() {
    this.buttonDisabled = true;
    this.radiusSliderValue = undefined;
    this.massSliderValue = undefined;
    this.sequenceControl.disable();
    this.sequenceControl.reset();
    this.classificationControl.disable();
    this.classificationControl.reset();
    this.slidersRadios.disable();
    this.slidersRadios.reset();
    this.radiusSlider.disable();
    this.radiusSlider.reset();
    this.massSlider.disable();
    this.massSlider.reset();
  }

  generateSolarSystem() {
    this.selectedCorp = false;
    this.currentPlanetSelected = undefined;
    this.currentSunSelected = undefined;

    let mass = 0.0;
    let radius = 0.0;
    if (this.slidersRadios.value === "RADIUS") {
      radius = this.radiusSlider.value;
    } else {
      mass = this.massSlider.value;
    }

    const requestedStar = {
      "SEQUENCE": `${this.sequenceControl.value}`,
      "CLASS": `${this.classificationControl.value}`,
      "RADIUS": `${radius}`,
      "MASS": `${mass}`,
    };

    this._http.post(this.urlBase + '/custGen', requestedStar, {
      headers:
        { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' }
    }).subscribe((response: PredefResponse) => {
      this.currentSun = response.star
      this.currentPlanets = response.ArrayPlanets;
      this.displayRepresentation = true;
    });
  }
}

