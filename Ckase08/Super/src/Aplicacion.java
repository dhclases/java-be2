import digital.house.producto.Producto;
import digital.house.tarjeta.Tarjeta;

public class Aplicacion {
    public static void main(String[] args) {
        // Definir el procesador ppal
         ProcesadorDescuento procesadorDescuento = new ProcesadorDescuento();

         // Definir las entidades a procesar

        Tarjeta tarjeta = new Tarjeta("234567890", "Star Bank");
        Producto producto = new Producto("arvejas", "lata");

        System.out.println("Descuento neto: " + procesadorDescuento.descuento(tarjeta, producto, 10));




    }
}


//TODO: Crear modelo de entidades
//TODO: Crear Los descuentos por Producto, Volumen, Tarjeta
//TODO: Crear Facade o Procesador de Descuento

/*
Dudas de la clase
Esto va dentro del main
 Map<Integer, Persona> mp = new HashMap<Integer,Persona>();
        Persona p = new Persona(4,"María",167);

        mp.put(4, p); // Añadimos un objeto persona al map
        p = new Persona(1,"Marta",165);
        mp.put(1, p); // Añadimos un objeto persona al map
        p = new Persona(3,"Elena",185);
        mp.put(3, p); // Añadimos un objeto persona al map
        p = new Persona(2,"Yolanda",174);
        mp.put(2, p); // Añadimos un objeto persona al map
        p = new Persona(5,"María Dolores",169);
        mp.put(4, p); // Esto crea una colisión ¡Dos objetos no pueden tener la misma clave!

        for (Map.Entry<Integer,Persona> entry : mp.entrySet())
            System.out.println("Tipo 1 Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        // forEach(action) method to iterate map
        mp.forEach((k,v) -> System.out.println("Tipo 2 Key = "
                + k + ", Value = " + v));

        System.out.println("Personas en el mapa Tipo 3: \n"+mp.toString().replaceAll(",", "\n"));
    }



 */
