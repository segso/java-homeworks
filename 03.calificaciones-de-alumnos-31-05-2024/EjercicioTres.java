import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Alumno {
    private String nombre;
    private short edad;
    private String especialidad;
    private byte calificacion;

    public Alumno(String nombre, short edad, String especialidad, byte calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "El alumno \"" + nombre + "\" de "
                + edad + (edad == 1 ? " año" : " años")
                + " de " + especialidad
                + " tiene " + calificacion + ".";
    }
}

public class EjercicioTres {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<Alumno> aprobados = new ArrayList<>(6);
        List<Alumno> reprobados = new ArrayList<>(6);
        List<Alumno> condicionados = new ArrayList<>(6);

        for (byte i = 1; i <= 6; i++) {
            System.out.print("Introduzca el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduzca la edad: ");
            short edad = scanner.nextShort();
            // Eliminar newline (\n) del buffer
            scanner.nextLine();

            System.out.print("Introduzca la especialidad: ");
            String especialidad = scanner.nextLine();

            System.out.print("Introduzca calificacion entre 0 y 10: ");
            byte calificacion = scanner.nextByte();
            // Eliminar newline (\n) del buffer
            scanner.nextLine();

            Alumno alumno = new Alumno(nombre, edad, especialidad, calificacion);

            if (calificacion == 0) {
                condicionados.add(alumno);
            } else if (calificacion <= 5) {
                reprobados.add(alumno);
            } else if (calificacion >= 6) {
                aprobados.add(alumno);
            }

            System.out.println("Aprobados: " + aprobados.size());
            aprobados.forEach(System.out::println);
            System.out.println();

            System.out.println("Reprobados: " + reprobados.size());
            reprobados.forEach(System.out::println);
            System.out.println();

            System.out.println("Condicionados: " + condicionados.size());
            condicionados.forEach(System.out::println);
            System.out.println();
        }

        scanner.close();
    }
}
