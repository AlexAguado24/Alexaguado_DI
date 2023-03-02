import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'alex-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'josealejandroaguadomerino';

  constructor(private gestor: Router) {}

  navegarBuscador() {
    this.gestor.navigate(['buscador']);
  }
  navegarVehiculos(tipo: string) {
    this.gestor.navigate(['vehiculos', tipo]);
  }
}
