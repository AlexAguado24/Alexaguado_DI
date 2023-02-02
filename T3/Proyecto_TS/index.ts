//function funcionNormal(param1:Number,param2: Number ): Number {}


function optativo(param1:String,param2: String, p3?: Number ) {
    console.log(param1);
    console.log(param2);
    console.log(p3);
}


function defecto(p1:String, p2:String, p3:Number = 2 ) {
    console.log(p1);
    console.log(p2);
    console.log(p3);
}

class alumno {

    constructor(private nombre:String,
        private apellido:String,
        private correo:String)
         {
    }
}

