function solicitaNum(nombre){
    return eval(prompt("Introduce "+nombre,"0"))
}

let numA=solicitaNum("numA")
let numB=solicitaNum("numB")

let mayor
let menor

function compruebaMayor(){
    if(numA>numB){
        mayor=numA
        menor=numB
    }
    else{
        mayor=numB
        menor=numA
    }
}

compruebaMayor()