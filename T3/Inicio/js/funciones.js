function ejemploFuncion() {
    console.log("Ejecucion de una funcion normal");
};

function funcionConParametros(parametroUno,parametroDos) {
    console.log(`${parametroUno} ${parametroDos}`);
};

//ejemploFuncion();
//funcionConParametros("hola", false);--> se puede pasar cualquier cosa--> lenguaje no tipado

// argumentos invisibles

function funcionArgumentosInvisibles() {
    console.log(arguments);
}

funcionArgumentosInvisibles("uno","dos","tres","cuatro");

//funciones con retorno
function funcionConRetorno(numeroUno,numerodos) {
    return numeroUno+numerodos
}

function funcionRetornoFuncion(parametroUno, parametroDos) {
    return funcionConRetorno(parametroUno,parametroDos)
}

function suma(p1, p2) {
    console.log(`${p1+p2}`);
}

function funcionDiv(p1,p2) {
    
}

function funcionParametrosFuncion(paramUno,paramDos,paramTres) {
    paramUno(paramDos,paramTres)
}

//funcionParametrosFuncion(suma, 5,10)

/* Funciones Anonimas */
let variableAnonima = function (para1, para2) {
    console.log(`parametros pasados ${arguments.length}`);
    console.log(`${para1}`);
    console.log(`${para2}`);
}
//variableAnonima(1,2,"afad")

function funcionConAnonima(para1,para2,para3) {
    para1(para2,para3)
}
funcionConAnonima(function (p1,p2) {
    console.log(`${p1*p2}`);
},
5,
10
);



