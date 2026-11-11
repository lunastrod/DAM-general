"""
Crea una aplicación que permita adivinar un número.
Crea un número secreto con un valor del 1 al 100.
A continuación, va pidiendo números 
y va respondiendo si el número a adivinar es mayor o menor que el introducido,
además de los intentos que te quedan (tienes 5 intentos para acertarlo).
El programa termina cuando se acierta el número (además te dice en cuantos intentos lo has acertado),
si se llega al límite de intentos te muestra el número que había generado.
"""

import random

NUMERO_INTENTOS = 5

numero_secreto = random.randint(1,100)
#print(numero_secreto)


intentos = 0
adivinado = False
while(intentos < NUMERO_INTENTOS and not adivinado):
    numero_usuario =- 1
    while(numero_usuario == -1):
        try:
            numero_usuario=int(input("Introduce un número entre 1 y 100: "))
            if(numero_usuario < 1 or numero_usuario > 100):
                numero_usuario = -1
                print("el numero debe estar entre 1 y 100")
        except:
            print("formato de numero incorrecto")
    
    intentos+=1
    

    if(numero_secreto < numero_usuario):
        print("el numero secreto es menor")
        print("quedan",NUMERO_INTENTOS-intentos,"intentos")
    elif(numero_secreto > numero_usuario):
        print("el numero secreto es mayor")
        print("quedan",NUMERO_INTENTOS-intentos,"intentos")
    else:
        adivinado=True

if(adivinado):
    print("Has adivinado el número secreto en",intentos,"intentos!")
else:
    print("Has fallado")
    