console.log("Script ejecutado desde fuera");

// variables
//no existen tipos en definicion -> no tipado  
let numero = 5; // number Integer
let numeroDecimal = 3.14; //number Float
let palabras = "Esto es un ejemplo de palabra en js";// String
let letras = "A"; //String char
let experiencia = true; //Boolean
let sinDefinir = undefined; // undefined 
let objeto = null; // null
let coleccion = []; // array --> Any
let fechaActual = new Date();


/* console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof palabras);
console.log(typeof letras);
console.log(typeof experiencia);
console.log(typeof sinDefinir);
console.log(typeof objeto);
console.log(typeof coleccion);
console.log(typeof fechaActual); */


//alert("Ejemplo de mensaje de aviso")
//window.confirm("Ejemplo de mensaje de confirmacion")
//prompt("Ejemplo de mensaje de introduccion")

/* let confirmacion = confirm("Estas seguro que quieres continuar");
console.log(confirmacion);
 */

/* if (confirmacion) {
    let datos =  Number(prompt("Introduce datos que se piden"))
    console.log(datos)
    console.log(typeof datos);
} else {
    console.log("me han confirmado");
} */


/* let op1 = Number(prompt("Introduce el primer operando"))
let op2 = Number(prompt("Introduce el segundo operando"))




if (!isNaN(op1) || !isNaN(op2)) {
    alert(`${op1}*${op2}=${op1*op2}`)
    alert(`${op1}+${op2}=${op1+op2}`)
    alert(`${op1}-${op2}=${op1-op2}`)
    alert(`${op1}/${op2}=${op1/op2}`)
    alert(`${op1}%${op2}=${op1%op2}`)
} else {
    alert("Uno de los elementos no coincide con las condiciones")
} */

// constantes 
const elementoNoCambiante = "Dato";
elementoNoCambiante = "asasda";


// if ternario --> condicion ? cuando es true: cuando es false