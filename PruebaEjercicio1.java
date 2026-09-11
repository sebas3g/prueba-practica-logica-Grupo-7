import java.util.Locale;
import java.util.Scanner;

public class PruebaEjercicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p1 = leerPuntaje(sc, "Reto 1");
        int p2 = leerPuntaje(sc, "Reto 2");
        int p3 = leerPuntaje(sc, "Reto 3");
        int errores = leerErrores(sc);
        double tiempo = leerTiempo(sc);
        boolean extra = leerSiNo(sc, "Resolvio el desafio extra? (S/N): ");
        boolean descalificado = leerSiNo(sc, "Fue descalificado por copia? (S/N): ");

        int puntajeBase = p1 + p2 + p3;
        int penalizacion = errores * 4;
        int bonificacion = 0;

        if (extra) {
            bonificacion = bonificacion + 15;
        }
        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        int puntajeFinal = puntajeBase - penalizacion + bonificacion;
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        String nivel;
        if (puntajeFinal >= 90) {
            nivel = "Experto";
        } else if (puntajeFinal >= 70) {
            nivel = "Avanzado";
        } else if (puntajeFinal >= 50) {
            nivel = "Intermedio";
        } else if (puntajeFinal >= 30) {
            nivel = "Basico";
        } else {
            nivel = "Principiante";
        }

        if (descalificado) {
            nivel = "Descalificado";
        }

        String observacion = "Sin observaciones";
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolucion";
        }

        System.out.println("");
        System.out.println("----- RESULTADOS -----");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalizacion: " + penalizacion);
        System.out.println("Bonificacion: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observacion: " + observacion);

        sc.close();
    }

    // Lee el puntaje de un reto, validando que este entre 0 y 100
    private static int leerPuntaje(Scanner sc, String nombreReto) {
        int valor;
        do {
            System.out.print("Ingrese puntaje de " + nombreReto + " (0 a 100): ");
            while (!sc.hasNextInt()) {
                System.out.print("Valor invalido. Ingrese un numero entero entre 0 y 100: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < 0 || valor > 100) {
                System.out.println("El puntaje debe estar entre 0 y 100.");
            }
        } while (valor < 0 || valor > 100);
        return valor;
    }

    // Lee el numero de errores, validando que no sea negativo
    private static int leerErrores(Scanner sc) {
        int valor;
        do {
            System.out.print("Ingrese numero de errores (0 o mas): ");
            while (!sc.hasNextInt()) {
                System.out.print("Valor invalido. Ingrese un numero entero mayor o igual a 0: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < 0) {
                System.out.println("El numero de errores no puede ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }

    // Lee el tiempo total en minutos, validando que sea mayor a 0
    private static double leerTiempo(Scanner sc) {
        double valor;
        do {
            System.out.print("Ingrese tiempo total en minutos (mayor a 0): ");
            while (!sc.hasNextDouble()) {
                System.out.print("Valor invalido. Ingrese un numero mayor que 0: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor <= 0) {
                System.out.println("El tiempo debe ser mayor que 0.");
            }
        } while (valor <= 0);
        return valor;
    }

    // Lee una respuesta Si/No y la valida hasta que sea correcta
    private static boolean leerSiNo(Scanner sc, String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje);
            respuesta = sc.next().trim().toUpperCase(Locale.ROOT);
            if (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.println("Respuesta invalida. Escriba S o N.");
            }
        } while (!respuesta.equals("S") && !respuesta.equals("N"));
        return respuesta.equals("S");
    }
}