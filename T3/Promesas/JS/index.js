let urlString = "https://dummyjson.com/products/categories";

fetch(urlString)
.then((res) => res.json()
).then((res1) => {
    res1.forEach(element => {
        console.log(`${element}`);
    });
})
.catch((err) => {
    console.log("fetch resulta sin exito");
})
.finally(() => {
    console.log("Fin de la evaluacion de la promesa");
});
