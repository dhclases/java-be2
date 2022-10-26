package main.java.demo;

import main.java.demo.model.Leon;
import main.java.demo.model.Tigre;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Aplicacion {
    private static final Logger logger = Logger.getLogger(Aplicacion.class);

    public static void main(String[] args) {
        logger.info("Test de logger");

        Leon leon = new Leon();
        leon.setEdad(4);
        leon.setNombre("Leon es Zimba");
        leon.setEsAlfa(true);
        leon.correr();

        try {
            leon.esMayorA10();
        } catch (Exception e) {
           logger.error("La edad del leon "+ leon.getNombre() +" es incorrecto ");
        }


        Leon leon2 = new Leon();
        leon2.setEdad(-1);
        leon2.setNombre("Leon es de otra vida");
        leon2.setEsAlfa(true);
        leon2.correr();

        try {
            leon2.esMayorA10();
        } catch (Exception e) {
            logger.error("La edad del leon "+ leon.getNombre() +" es incorrecto ");
        }


    }
}
