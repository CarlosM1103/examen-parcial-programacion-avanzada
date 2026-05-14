package org.example;

import java.util.concurrent.Callable;

public class BuscadorPalabra implements Callable<Integer> {
    private final String[] fila;
    private final String palabra;
    private final int idHilo;

    public BuscadorPalabra(int idHilo, String[] fila, String palabra) {
        this.idHilo = idHilo;
        this.fila = fila;
        this.palabra = palabra;
    }

    @Override
    public Integer call() {
        int conteo = 0;
        for (String s : fila) {
            if (s.equals(palabra)) {
                conteo++;
            }
        }
        System.out.println("Hilo-" + idHilo + " finalizado. Encontrados: " + conteo);
        return conteo;
    }
}
