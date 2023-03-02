import { Component } from '@angular/core';
import { Coche } from 'src/app/model/Coche';
import { CochesService } from 'src/app/service/coches.service';

@Component({
  selector: 'alex-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css'],
})
export class BuscadorComponent {
  constructor(private servicioCoches: CochesService) {}

  arrayCoches: Coche[] = [];

  buscarCoches(marca: string, cv: string) {
    this.arrayCoches = this.servicioCoches.filtrarCochesMarcaCv(
      marca,
      Number(cv)
    );
  }
}
