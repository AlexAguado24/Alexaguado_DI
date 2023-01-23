console.log("Declaracion de variables");
//let var const
let profesor = {
    nombre: "Borja",
    apellido: "Martin",
    asignaturas: [
        {nombre:"Programacion", horas:6},
        {nombre: "DI", horas: 6}
    ]
}
let profesor2 = {
    nombre: "Jesus",
    apellido: "Niño",
    asignaturas: [
        {nombre:"Programacion de procesos", horas:4},
        {nombre: "Entornos de desarrollo", horas: 3}
    ]
}


let nombre: String = "Borja";
let edad: Number = 38;
let asignaturas: Array<String> = ["Programacion","DI","PMDM"]

asignaturas.forEach((element)=>{
    console.log(element);
})


function mostrarAsignaturas(asignaturas:Array<any>) {
    asignaturas.forEach(element => {
        console.log(element.nombre);
    });
}

mostrarAsignaturas(profesor2.asignaturas)


