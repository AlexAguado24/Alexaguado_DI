import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ejerciciorepaso-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ejerciciorepaso';

  constructor(private gestor:Router){}

  navegar(ciclo:string){
    this.gestor.navigate(['cursos', ciclo])
  }

}
