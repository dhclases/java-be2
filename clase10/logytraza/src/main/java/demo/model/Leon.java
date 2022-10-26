package main.java.demo.model;

import org.apache.log4j.Logger;


public class Leon {
    private static final Logger logger = Logger.getLogger(Leon.class);

    private String nombre;
    private int edad;
    private boolean esAlfa;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(boolean esAlfa) {
        this.esAlfa = esAlfa;
    }

    public void correr(){
        logger.info("El nombre " + nombre + "esta corriendo");
    }

    public void esMayorA10() throws Exception {
        logger.info("Iniciando proceso de evaluacìón de Mayoria");
        if(edad > 10 && isEsAlfa()){
            logger.info("El Leòn "+nombre+ "es mayor a 10 años es ccrrecto");
        }
        if(edad < 0 ){
            logger.error("La edad no puede ser negativa");
            throw new Exception();
        }
        logger.info("Culminando proceso de evaluacìón de Mayoria");
    }


}
