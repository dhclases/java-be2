package digital.house;


import digital.house.flyweight.factory.ComputerFactory;
import digital.house.flyweight.model.Computer;

public class Aplication {
    // Cliente
    public static void main(String[] args) {
        System.out.println("hola Mundo");
        System.out.printf("hola Mundo  \t%s %s \n", "Luis Miguel","otra cosa");

  /*      // (1) Definir factory
        ComputerFactory computerFactory = new ComputerFactory();

        // (2)  Definir objeto
        Computer equipo;

        // Simular un numero de objectos
        for (int i = 1; i < 24; i++) {
            if (esPar(i)) {
                equipo = computerFactory.crearComputadora(16, 500);
            } else {
                equipo = computerFactory.crearComputadora(2, 128);
            }
        }

        //Evaluar cuantos son de cache
        System.out.println("Total en cache: " + Computer.getContador());

        */

    }

    public static boolean esPar(int numero) {
        return ((numero % 2) == 0);
    }
}

//TODO: Modelo Computer
//TODO: Factory Computer
//TODO: Main Computer
