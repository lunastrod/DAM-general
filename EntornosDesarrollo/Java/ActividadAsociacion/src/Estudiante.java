/*
− Clase Estudiante
• Atributos: nombre, apellido, identificador del estudiante, una colección (por ejemplo,
ArrayList) de profesores.
• Métodos: Constructor (sin necesidad de profesores iniciales), método para agregar
un profesor, método para eliminar un profesor y método para mostrar la
información del estudiante junto con uno de sus profesores
*/

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int identificador;
    private ArrayList<Profesor> profesores;

    public Estudiante(String nombre, String apellido, int identificador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificador = identificador;
        this.profesores = new ArrayList<>();
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void eliminarProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Identificador: " + identificador);
        if (!profesores.isEmpty()) {
            for (Profesor profesor : profesores) {
                System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + ", Materia: " + profesor.getMateria());
            }
        } else {
            System.out.println("No tiene profesores asignados.");
        }
    }

}
