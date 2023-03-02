import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Coche } from 'src/app/model/Coche';
import { CochesService } from 'src/app/service/coches.service';

@Component({
  selector: 'alex-vehiculos',
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css'],
})
export class VehiculosComponent {
  tipoCoche = '';

  cochesUtilitarios: Coche[] = [];

  constructor(
    private servicioCoches: CochesService,
    private gestorRutas: ActivatedRoute
  ) {
    gestorRutas.params.subscribe((param) => {
      this.tipoCoche = param['id'];
      this.cochesUtilitarios = this.servicioCoches.getCochesFiltrados(
        this.tipoCoche
      );
    });
  }
}
