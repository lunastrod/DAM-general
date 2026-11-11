"""
Escribe un programa que pida el límite inferior y superior de un intervalo.
Si el límite inferior es mayor que el superior lo tiene que volver a pedir.
A continuación se van introduciendo números hasta que introduzcamos el 0.
Cuando termine el programa dará las siguientes informaciones:
    La suma de los números que están dentro del intervalo (intervalo abierto).
    Cuantos números están fuera del intervalo.
    E informa si hemos introducido algún número igual a los límites del intervalo.
"""
valido = False
l_superior = -1
l_inferior = -1
while not valido:
    try:
        l_superior = int(input("Introduce el límite superior: "))
        l_inferior = int(input("Introduce el límite inferior: "))
        if(l_superior < l_inferior):
            print("El límite inferior es mayor que el superior")
        else:
            valido=True
    except:
        print("formato de numero no válido")

numero = -1
suma = 0
fuera_intervalo = 0
igual_limites = False
while numero!=0:
    try:
        numero=int(input("Introduce un numero: "))
        if(numero==0):
            print("terminando")
        elif(numero<l_inferior or numero>l_superior):
            fuera_intervalo+=1
        elif(numero==l_inferior or numero==l_superior):
            igual_limites=True
        else:#dentro del intervalo
            suma+=numero
    except:
        print("formato de numero no válido")

print("La suma de los números que están dentro del intervalo es:",suma)
print("Números fuera del intervalo:",fuera_intervalo)
if(igual_limites):
    print("Hemos introducido algun numero igual a los limites")
else:
    print("No hemos introducido ningun numero igual a los limites")