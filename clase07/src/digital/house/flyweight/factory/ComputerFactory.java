package digital.house.flyweight.factory;


import digital.house.flyweight.model.Computer;

import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {
    // Definir Cache de Objectos
    private static Map<String, Computer> equipos = new HashMap<>();

    // Crear objetos y validar que si exiten

    public Computer crearComputadora(int ram, int disco){
        String key = "key" + ram + ":" + disco;
        System.out.printf("Comenzando a crear el perfil: %s \n ", key);

        if(!equipos.containsKey(key)){
            equipos.put(key, new Computer(ram, disco));
            System.out.printf("Creada la PC: %s \n", key);
            return equipos.get(key);
        }
        System.out.println("PC desde cache");
        return equipos.get(key);
    }

}
