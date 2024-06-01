import java.util.Scanner;

public class EjercicioDos {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        do {
            System.out.print("Ingrese el valor de a: ");
            double a = scanner.nextDouble();

            System.out.print("Ingrese el valor de b: ");
            double b = scanner.nextDouble();

            System.out.print("Ingrese el valor de c: ");
            double c = scanner.nextDouble();

            // Eliminar newline (\n) del buffer
            scanner.nextLine();

            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("Todos los valores deben ser mayores a cero.\n");
                continue;
            }

            double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

            System.out.println("X₁ vale " + x1 + "\nX₂ vale " + x2 + "\n");

            System.out.println("¿Desea continuar?");

            String respuesta = scanner.nextLine();
            if (respuesta.trim().equalsIgnoreCase("no")) {
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }
}
