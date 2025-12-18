let nombre="Daniel"
let apellido="Parra"
let edad=25

function pedirInfo(){
    nombre=prompt("Introduce nombre");
    apellido=prompt("Introduce apellido");
    edad=eval(prompt("Introduce edad"));
}

function bienvenida(){
    alert("Hola Mr/Ms "+apellido);
}

function finalizar(){
    if(confirm("Muchas gracias, ¿desea continuar?")){
        alert("Esto es todo amigos!!");
    }
    else{
        alert("Se acabó!");
    }
}