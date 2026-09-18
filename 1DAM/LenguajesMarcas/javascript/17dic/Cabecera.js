function solicitaNum(nombre){
    return eval(prompt("Introduce "+nombre,"0"))
}

function solicitaString(nombre){
    return prompt("Introduce "+nombre,"")
}

function escribeCabecera(numCabecera,texto){
    document.write("<h"+numCabecera+">"+texto+"</h"+numCabecera+">")
}

let num=solicitaString("tamaño de cabecera")
let txt=solicitaString("texto")