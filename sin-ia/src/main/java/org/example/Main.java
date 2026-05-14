package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        String palabraBusqueda = "Java";
        System.out.println("Iniciando búsqueda concurrente del término: \"" + palabraBusqueda + "\"");

        Thread[] hilos = new Thread[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            hilos[i] = new Thread("Hilo-" + i, matriz[i], palabraBusqueda);
            hilos[i].start();
        }

        int total = 0;

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
                total += hilos[i].getConteoParcial();
            } catch (InterruptedException e) {
                System.out.println("Error en la ejecución del hilo: " + e.getMessage());
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Resultado Total: La palabra \"" + palabraBusqueda + "\" aparece " + total + " veces.");
    }
}

