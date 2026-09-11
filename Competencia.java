package prueba;

import java.util.Scanner;

public class Competencia {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int puntaje1, puntaje2, puntaje3;
        int errores, tiempo;
        int puntajeBase;
        int penalizacion;
        int bonificacion = 0;
        int puntajeFinal;
        String desafioExtra;
        String descalificado;
        String nivel;
        String observacion = "";

        System.out.print("Ingrese puntaje del reto 1: ");
        puntaje1 = entrada.nextInt();

        System.out.print("Ingrese puntaje del reto 2: ");
        puntaje2 = entrada.nextInt();

        System.out.print("Ingrese puntaje del reto 3: ");
        puntaje3 = entrada.nextInt();

        System.out.print("Ingrese número de errores: ");
        errores = entrada.nextInt();

        System.out.print("Ingrese tiempo total en minutos: ");
        tiempo = entrada.nextInt();

        entrada.nextLine();

        System.out.print("¿Resolvio el desafio extra? (Si/No): ");
        desafioExtra = entrada.nextLine();

        System.out.print("¿Fue descalificado por copia? (Si/No): ");
        descalificado = entrada.nextLine();

        // Calcular puntaje base
        puntajeBase = puntaje1 + puntaje2 + puntaje3;

        // Calcular penalización
        penalizacion = errores * 4;

        // Calcular bonificaciones
        if (desafioExtra.equalsIgnoreCase("Si")) {
            bonificacion = bonificacion + 15;
        }

        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // Calcular puntaje final
        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // Evitar puntaje negativo
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Determinar nivel
        if (descalificado.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        } else if (puntajeFinal >= 90) {
            nivel = "Experto";
        } else if (puntajeFinal >= 70) {
            nivel = "Avanzado";
        } else if (puntajeFinal >= 50) {
            nivel = "Intermedio";
        } else if (puntajeFinal >= 30) {
            nivel = "Básico";
        } else {
            nivel = "Principiante";
        }

        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);

        if (!observacion.equals("")) {
            System.out.println("Observación: " + observacion);
        }
    }
}
