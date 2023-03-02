import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'rutas-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'rutas';

  constructor(private gestorRutas: Router){

  }

  navegarComponente(numero : number){
    this.gestorRutas.navigate(['comunicar',numero])
  }


}
