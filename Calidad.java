package prueba;
import java.util.Scanner;

public class Calidad {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double analisis, diseno, codificacion;
        double promedio, ajuste, notaFinal, avance;
        int errores;
        boolean documentacion, exposicion;
        String estado;

        do {
            System.out.print("Ingrese nota de análisis (0-10): ");
            analisis = entrada.nextDouble();
            if (analisis < 0 || analisis > 10) {
                System.out.println("Número incorrecto. La nota debe estar entre 0 y 10.");
            }
        } while (analisis < 0 || analisis > 10);


        do {
            System.out.print("Ingrese nota de diseño (0-10): ");
            diseno = entrada.nextDouble();
            if (diseno < 0 || diseno > 10) {
                System.out.println("Número incorrecto. La nota debe estar entre 0 y 10.");
            }
        } while (diseno < 0 || diseno > 10);

        do {
            System.out.print("Ingrese nota de codificación (0-10): ");
            codificacion = entrada.nextDouble();
            if (codificacion < 0 || codificacion > 10) {
                System.out.println("Número incorrecto. La nota debe estar entre 0 y 10.");
            }
        } while (codificacion < 0 || codificacion > 10);

        System.out.print("Ingrese porcentaje de avance real: ");
        avance = entrada.nextDouble();

        System.out.print("Ingrese número de errores detectados: ");
        errores = entrada.nextInt();

        System.out.print("¿Presentó documentación completa? (Si/No): ");
        String respuesta = entrada.next();

        documentacion = respuesta.equalsIgnoreCase("Si");

        System.out.print("¿Realizó exposición final? (Si/No): ");
        respuesta = entrada.next();

        exposicion = respuesta.equalsIgnoreCase("Si");

        promedio = (analisis + diseno + codificacion) / 3;
        ajuste = errores * -0.5;

        if (documentacion) {
            ajuste = ajuste + 0.5;
        }
        if (exposicion) {
            ajuste = ajuste + 0.5;
        }
        notaFinal = promedio + ajuste;

        if (notaFinal > 10) {
            notaFinal = 10;
        }

        if (notaFinal < 0) {
            notaFinal = 0;
        }

        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        if (notaFinal >= 7 && !documentacion) {
            System.out.println("Observación: Buen producto, pero mala formalidad");
        }

        // Resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Promedio técnico: " + promedio);
        System.out.println("Ajustes aplicados: " + ajuste);
        System.out.println("Nota final: " + notaFinal);
        System.out.println("Estado: " + estado);

    }
}