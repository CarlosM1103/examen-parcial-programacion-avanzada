package org.example;


public class Thread extends java.lang.Thread {
    private String[] fila;
    private String palabraBuscada;
    private int conteoParcial;

    public Thread(String nombre, String[] fila, String palabraBuscada) {
        super(nombre);
        this.fila = fila;
        this.palabraBuscada = palabraBuscada;
        this.conteoParcial = 0;
    }

    @Override
    public void run() {
        for (String palabra : fila) {
            if (palabra.equals(palabraBuscada)) {
                conteoParcial++;
            }
        }
        System.out.println(getName() + " finalizado. Encontrados: " + conteoParcial);
    }

    public int getConteoParcial() {
        return conteoParcial;
    }
}
