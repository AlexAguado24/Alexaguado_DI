import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ejerciciocursos-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ejerciciocursos';

  constructor(private gestorRutas: Router){}

  navegar(ciclo:string){
    this.gestorRutas.navigate(['cursos',ciclo])
  }

}
