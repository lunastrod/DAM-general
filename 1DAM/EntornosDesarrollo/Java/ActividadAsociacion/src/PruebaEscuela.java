/*
ASOCIACIÓN
Se desea modelar la relación entre profesores y estudiantes, sabiendo que:
− Un estudiante puede tener varios profesores.
− Un profesor puede impartir clase a varios estudiantes.
− La relación entre ambos es de tipo asociación, lo que significa que:
• Ninguno depende del otro para existir.
• Pueden crearse de forma independiente.
• La relación puede establecerse y eliminarse en cualquier momento.

− Clase PruebaEscuela (Main)
• Debe crear, al menos, 1 profesor y 1 estudiante.
• Establecer la relación entre ellos (asociación)
• Mostrar la información del estudiante junto con el profesor
• Eliminar la relación
− La relación debe ser bidireccional opcional (solo desde estudiante), no es obligatorio que
el profesor conozca a sus estudiantes.
− No se debe usar herencia.
− La eliminación de la relación no elimina los objetos, solo rompe el vínculo
*/

public class PruebaEscuela {
    public static void main(String[] args) {
        Profesor profesor1 = new Profesor("Carlos", "Elvira", "Entornos");
        Estudiante estudiante1 = new Estudiante("Yo", "Yoyoyo", 12345);
        estudiante1.agregarProfesor(profesor1);
        estudiante1.mostrarInformacion();
        System.out.println("Eliminando");
        estudiante1.eliminarProfesor(profesor1);
        estudiante1.mostrarInformacion();
    }
}
