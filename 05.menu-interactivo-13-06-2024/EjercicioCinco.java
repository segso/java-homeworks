package ejerciciocinco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class EjercicioCinco {
    static final int DIAS_POR_SEMANA = 7;

    public static double pendiente(double x1, double x2, double y1, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static double promedio(double... calificaciones) {
        return DoubleStream.of(calificaciones).sum() / calificaciones.length;
    }

    public static double salario(int horas, double pagoPorHora) {
        return horas * pagoPorHora * DIAS_POR_SEMANA;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Calcular pendiente");
            System.out.println("2. Calcular promedio");
            System.out.println("3. Calcular salario semanal");
            System.out.println("4. Salir");
            System.out.print(">> ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese x1, x2, y1, y2");
                    System.out.print(">> ");

                    double x1 = scanner.nextDouble();
                    double x2 = scanner.nextDouble();
                    double y1 = scanner.nextDouble();
                    double y2 = scanner.nextDouble();
                    scanner.nextLine();

                    double pendiente = pendiente(x1, x2, y1, y2);

                    if (Double.isNaN(pendiente)) {
                        System.out.println("Hubo un error al calcular la pendiente");
                        break;
                    }

                    System.out.println("La pendiente es: " + pendiente);
                    break;
                case 2:
                    System.out.println("Ingrese los promedios o escriba cancelar");

                    List<Double> promedios = new ArrayList<>();

                    while (true) {
                        System.out.print(">> ");
                        String promedio = scanner.nextLine();

                        if (promedio.equalsIgnoreCase("cancelar")) {
                            break;
                        }

                        promedios.add(Double.parseDouble(promedio));
                    }

                    System.out.println("El promedio es de: "
                            + promedio(
                                    promedios.stream()
                                            .mapToDouble(Double::doubleValue)
                                            .toArray()));
                    break;
                case 3:
                    System.out.println("Ingrese el pago por hora");
                    System.out.print(">> ");
                    double pagoPorHora = scanner.nextDouble();
                    System.out.println("Ingrese las horas trabajadas");
                    System.out.print(">> ");
                    int horas = scanner.nextInt();

                    System.out.println("El salario es de: " + salario(horas, pagoPorHora));
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Esa opción no existe");
            }
        } while (continuar);

        scanner.close();
    }
}
