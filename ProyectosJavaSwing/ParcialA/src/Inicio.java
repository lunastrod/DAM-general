/*
Prueba Parcial A T3 (24-25)
Escribir un programa con interfaz gráfico para realizar encuestas sobre las
series más vistas de los últimos tiempos.
Crea el proyecto PruebaParcialAT3_iniciales (por ejemplo,
PruebaParcialAT3_PMG).

La aplicación deberá implementarse siguiendo el patrón MVC, por lo que
deberás crear los paquetes correspondientes.

La ventana principal deberá tener en el marco el título E N C U E S T A S.

Deberá tener una agrupación de opciones de menú, Encuestas A, con dos
opciones de menú: Realizar Encuestas y Visualizar Encuestas.
Deberá tener un tamaño de 600x400.

a. Desde la opción Realizar Encuestas se podrá almacenar los datos de
cada encuesta realizada.
- Se deberán poder introducir los siguientes datos de una encuesta:
• el edad (JRadioButtons): Entre 5 y 17, entre 18 y 30, entre
31 y 40, entre 41 y 65 o más de 65 (marcar uno de inicio)
• la frecuencia con que ve series (JComboBox): Ninguna, 1 o
2 veces por semana, 3 o 4 veces por semana, 5 o 6 veces por
semana y Todos los días,
• series vistas por el encuestado (JCheckBox): Juego de
Tronos, Vikingos, Breaking Bad, Stranger Tings, El Cuento
de la Criada, El Juego del Calamar, Dragon Ball y 7 vidas,
- Además, deberá tener un botón, Guardar Encuesta, para guardar
los datos introducidos. Tras pulsar el botón se guardarán los datos
en una lista, se informará del resultado de la operación y se
limpiarán los datos de la encuesta guardada.
b. Desde la opción Visualizar Encuestas se visualizarán en una JList las
encuestas realizadas. De cada encuesta se mostrará el rango de edad,
la frecuencia y las series que ha visto.
Ej:
Entre 18 y 30 - 3 o 4 v/s - Series vistas: Juego de Tronos,
Vikingos, Stranger Things.

NOTA: Tened en cuenta en el POJO, a la hora de indicar cuál es la cadena
de caracteres que representa a una encuesta, que la frecuencia se debe
simplificar: si el atributo frecuencia es distinto de Ninguna y de Todos los
días, se sustituirá veces por semana por v/s. Y si es Todos los días, se
pondrá solo Todos. Y si es Ninguna se sustituirá por 0 v/s.
• Si no hay encuestas realizadas se mostrará un mensaje
indicándolo y no se mostrará el botón Ver Resultados.
• Si hay encuestas realizadas, además de mostrarse la lista,
se hará visible un botón, Ver Resultados.
• Si se pulsa el botón, Ver Resultados abrirá un JOptionPane
de Información con un mensaje con el resultado del siguiente
análisis:
o Cuántas personas se han encuestado de cada rango de
edad.
o Cuál es la frecuencia más usada.
o Cuál es la serie más vista
Código de los componentes de los paneles:
*/

import java.awt.EventQueue;

import com.dam.control.EncuestadorControlador;
import com.dam.model.ListaEncuestas;
import com.dam.view.VPrincipal;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VPrincipal ventanaPrincipal=new VPrincipal();
                ListaEncuestas modelo=new ListaEncuestas();
                EncuestadorControlador controlador=new EncuestadorControlador(ventanaPrincipal,modelo);
                ventanaPrincipal.setControlador(controlador);
                ventanaPrincipal.hacerVisible();
            }
        });
    }
}
