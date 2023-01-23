console.log("Declaracion de variables");
//let var const
var profesor = {
    nombre: "Borja",
    apellido: "Martin",
    asignaturas: [
        { nombre: "Programacion", horas: 6 },
        { nombre: "DI", horas: 6 }
    ]
};
var profesor2 = {
    nombre: "Jesus",
    apellido: "Niño",
    asignaturas: [
        { nombre: "Programacion de procesos", horas: 4 },
        { nombre: "Entornos de desarrollo", horas: 3 }
    ]
};
var nombre = "Borja";
var edad = 38;
var asignaturas = ["Programacion", "DI", "PMDM"];
asignaturas.forEach(function (element) {
    console.log(element);
});
function mostrarAsignaturas(asignaturas) {
    asignaturas.forEach(function (element) {
        console.log(element.nombre);
    });
}
mostrarAsignaturas(profesor2.asignaturas);
