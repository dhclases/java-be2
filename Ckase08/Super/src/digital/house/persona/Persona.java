package digital.house.persona;

public class Persona {


    private int idPersona;
    private String nombre;
    private int altura;


    public Persona(int idPersona, String nombre, int altura) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.altura = altura;
    }


    @Override

    public String toString() {
        return "Persona-> ID: " + idPersona + " Nombre: " + nombre + " Altura: " + altura;
    }

    @Override

    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Persona other = (Persona) obj;

        if (this.idPersona != other.idPersona) {
            return false;
        }

        return true;

    }


}
