package ejerciciocuatro;

import java.util.Scanner;

public class EjercicioCuatro {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        double[] ingles = new double[3];
        double[] español = new double[3];
        double[] programacion = new double[3];

        double[] promedios = new double[3];

        String[] nombres = { "inglés", "español", "programación" };
        double[][] materias = { ingles, español, programacion };

        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < ingles.length; j++) {
                System.out.printf("Ingrese la calificación %d de %s: ", j + 1, nombres[i]);
                double calificacion = scanner.nextDouble();

                materias[i][j] = calificacion;
            }
        }

        for (int i = 0; i < promedios.length; i++) {
            promedios[i] = (ingles[i] + español[i] + programacion[i]) / 3;
        }

        for (int i = 0; i < promedios.length; i++) {
            System.out.printf("El promedio del alumno %d es de %.2f%n", i + 1, promedios[i]);
        }

        scanner.close();
    }
}
