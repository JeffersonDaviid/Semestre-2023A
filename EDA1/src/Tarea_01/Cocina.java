/** 
 * @autor: Jefferson Chileno
 * @fecha: 13-05-2023
 */

/*
3.	Construir un sistema o programa que le permita a su madre visualizar datos de una cocina para comprarla, ella quiere que se verifique si enciende o no verificando un estado
Trabajar una clase llamada COCINA Atributos: altura, peso, ancho, largo,  modelo.
Va especificar una variable encendido en caso de ser automática de tipo boolean.
Va tener un constructor que va permitir inicializar las variables: Altura, ancho, peso 
Un método obtener Peso()
Un método obtenerAltura() 
Un método obtenerAncho() 
Un metodo encender() 
Un metodo apagar() 
Un método estado() en el que tengan las dos opciones de encendido y apagado.
 */

package Tarea_01;

import java.util.Scanner;

public class Cocina {
    private float altura;
    private float peso;
    private float ancho;
    private float largo;
    private String modelo;
    private boolean encendido;

    public Cocina(float altura, float ancho, float peso) {
        this.altura = altura;
        this.peso = peso;
        this.ancho = peso;
        this.largo = 2;
        this.modelo = "cocina X";
        this.encendido = false;
    }

    public Float obtenerPeso() {
        return this.peso;
    }

    public Float obtenerAltura() {
        return this.altura;
    }

    public Float obtenerAncho() {
        return this.ancho;
    }

    public void encender() {
        this.encendido = true;
        System.out.println("La cocina está encendida");
    }

    public void apagar() {
        this.encendido = false;
        System.out.println("La cocina está apagada");
    }

    public void estado() {

        if (encendido == false)
            encender();
        else
            apagar();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cocina cocina = new Cocina(Float.parseFloat("1.1"), Float.parseFloat("1.5"), Float.parseFloat("3.4"));

        do {
            System.out.println(
                    "\n\tSISTEMA DE ENCENDIDO DE COCINA\nOpciones:\n\n 1. Revisar encendido de la cocina\n 0. Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    return;
                case 1:
                    cocina.estado();

                    int contador = 0;
                    float i = 200;
                    while (i > 1) {
                        contador++;
                        i = i / 2;
                    }
                    System.out.println("el ultimo valor i: " + i);
                    System.out.println("se ejecutaron : " + contador);

                    break;
                default:
                    break;
            }

            try {
                Thread.sleep(5000); // Pausa de 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } while (true);

        // sc.close();

    }

}
