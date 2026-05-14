package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        String palabraBusqueda = "Java";
        System.out.println("Iniciando búsqueda concurrente del término: \"" + palabraBusqueda + "\"");

        // Optimización: Pool de hilos reutilizable
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> resultados = new ArrayList<>();

        // Lanzamiento de tareas
        for (int i = 0; i < matriz.length; i++) {
            resultados.add(executor.submit(new BuscadorPalabra(i, matriz[i], palabraBusqueda)));
        }

        int total = 0;
        try {
            for (Future<Integer> res : resultados) {
                total += res.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error en la ejecución del hilo: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Salida final idéntica a image_92fd9a.png
        System.out.println("-------------------------------------------------------");
        System.out.println("Resultado Total: La palabra \"" + palabraBusqueda + "\" aparece " + total + " veces.");
    }
}

