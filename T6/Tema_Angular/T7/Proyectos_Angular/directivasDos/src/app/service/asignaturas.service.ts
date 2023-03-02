import { Injectable } from '@angular/core';
import { Asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

  //datos
  private asignaturas: Asignatura[] = [
    {
      nombre: 'Desarrollo de interfaces',
      imagen : 'https://m.media-amazon.com/images/I/810Cwks+FaL.jpg',
      siglas : 'DI',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['java','js','angular']
    },
    {
      nombre: 'Kotlin',
      imagen : 'https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40',
      siglas : 'K',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['android','Kotlin']
    },
    {
      nombre: 'JS',
      imagen : 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png',
      siglas : 'js',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['js']
    },
    {
      nombre: 'Programación',
      imagen : 'https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp',
      siglas : 'PP',
      curso: 1,
      ciclo: 'DAM|DAW',
      profesor:'Borja',
      conocimientos: ['java']
    },
    {
      nombre: 'Base de datos',
      imagen : 'https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp',
      siglas : 'BBDD',
      curso: 1,
      ciclo: 'DAM|DAW',
      profesor:'Edu',
      conocimientos: ['MYSQL','workbench']
    },
    {
      nombre: 'Desarrollo cliente',
      imagen : 'https://reactjs.org/logo-og.png',
      siglas : 'DC',
      curso: 2,
      ciclo: 'DAW',
      profesor:'Edu',
      conocimientos: ['JS','Express','React']
    },
    {
      nombre: 'Desarrollo Servidor',
      imagen : 'https://www.qualitydevs.com/wp-content/uploads/2021/05/PHP-Quality-Devs-1-1288x724.jpg',
      siglas : 'DS',
      curso: 2,
      ciclo: 'DAW',
      profesor:'Edu',
      conocimientos: ['PHP','Servicios']
    },
  ]
  constructor() { }

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturas
  }

  getAsignaturasFiltradas(numero: number): Asignatura[]{

    if (numero == 1 || numero == 2) {
      return this.asignaturas.filter((item)=>item.curso == numero)
    } else {
      return this.asignaturas;
    }
  }

  getFiltroCiclo(cicloA:string): Asignatura[]{

    if (cicloA == 'DAM' || cicloA == 'DAW') {
      return this.asignaturas.filter((item)=>item.ciclo == cicloA)
    } else {
      return this.asignaturas;
    }

  }

}
