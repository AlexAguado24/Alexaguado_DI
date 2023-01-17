let urlString = "https://dummyjson.com/products";
let urlStringCategorias = "https://dummyjson.com/products/categories";
 
// jdbc
// connection.createStatement().executeQuery()
/* let selecciones = document.querySelector('select')
fetch(urlString).then((res) => res.json())
  .then((res1) => {
    res1.forEach(item => {
    console.log( `${item}`  )
    let option = document.createElement('option')
    option.value=item
    option.innerText=item
    selecciones.append(option)
    });
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  })
  .finally(() => {
    console.log("Fin de la evaluacion de la promesa");
  }); */


let selectCategorias = document.querySelector("select")

function cargarProductos() {
  fetch(urlString)
  .then((res)=>{

  }).then((res1)=>{

  }).catch((err)=>{
    
  })
}


function cargarCategorias() {
  fetch(urlStringCategorias)
.then((res) => {
  return res.json();
}).then((res1) => {
  res1.forEach(element => {
    selectCategorias.innerHTML += `<option value="${element}">${element}</option>`;
  });
})
.catch((err) => {
  console.log(`Error en la empresa ${err}`);
})
}