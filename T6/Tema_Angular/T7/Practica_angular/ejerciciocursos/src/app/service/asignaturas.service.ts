import { Injectable } from '@angular/core';
import { Asignatura } from '../model/Asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

  private asignaturas : Asignatura[] = [
    {
      nombre : 'Desarrollo de interfaces',
      imagen : 'https://m.media-amazon.com/images/I/810Cwks+FaL.jpg',
      siglas : 'DI',
      ciclo : 'DAM',
      curso : 2,
      comocimientos : ['JS','java','angular']
    },
    {
      nombre : 'Programacion Multimedia',
      imagen : 'https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40',
      siglas : 'PM',
      ciclo : 'DAM',
      curso : 2,
      comocimientos : ['android','kotlin']
    },
    {
      nombre : 'Ingles',
      imagen : 'https://educacion30.b-cdn.net/wp-content/uploads/2021/11/english-british-england-language-education-concept-1-min-978x652.jpg',
      siglas : 'II',
      ciclo : 'DAM|DAW',
      curso : 2,
      comocimientos : ['ingles']
    },
    {
      nombre : 'Programacion de servicios',
      imagen : 'https://teorema-rd.com/storage/2020/09/powershell-1.jpg',
      siglas : 'PS',
      ciclo : 'DAM',
      curso : 2,
      comocimientos : ['NINGUNO']
    },
    {
      nombre : 'Base de datos',
      imagen : 'https://gdm-catalog-fmapi-prod.imgix.net/ProductLogo/6a813a0c-ba36-40ae-82f3-85b420391de1.png?auto=format&q=50&w=80&h=80&fit=max&dpr=3',
      siglas : 'BBDD',
      ciclo : 'DAM',
      curso : 1,
      comocimientos : ['MySQL', 'workbench']
    },
    {
      nombre : 'Programacion',
      imagen : 'https://m.media-amazon.com/images/I/810Cwks+FaL.jpg',
      siglas : 'PP',
      ciclo : 'DAW',
      curso : 1,
      comocimientos : ['Java']
    },
    {
      nombre: 'Desarrollo cliente',
      imagen : 'https://reactjs.org/logo-og.png',
      siglas : 'DC',
      curso: 2,
      ciclo: 'DAW',
      comocimientos : ['JS','Express','React']
    },
    {
      nombre: 'Desarrollo Servidor',
      imagen : 'https://www.qualitydevs.com/wp-content/uploads/2021/05/PHP-Quality-Devs-1-1288x724.jpg',
      siglas : 'DS',
      ciclo: 'DAW',
      curso: 2,
      comocimientos : ['PHP','Servicios']
    }
  ]

  constructor() { }

  getAllAsignaturas(): Asignatura[]{
    return this.asignaturas;
  }

  getAsgnaturasFiltradas(ciclo:string): Asignatura[]{
    switch (ciclo) {
      case 'DAM':
        return this.asignaturas.filter((item)=>item.ciclo === ciclo)
      default:
        return this.asignaturas.filter((item)=>item.ciclo === ciclo)
    }
  }

}
