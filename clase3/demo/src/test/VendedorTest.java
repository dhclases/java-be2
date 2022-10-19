package test;


import com.dh.ventas.model.Afiliado;
import com.dh.ventas.model.Empleado;
import com.dh.ventas.model.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VendedorTest {

    @Test
    //TODO: Case 1
    //  respuestaEsperada "Pedro tiene un total de n puntos y categoriza como aprendiz"

    void mostrarCategoria_deberiaCategorizarElEmpleadoComoAprendiz() {
        //DADO
        Empleado empleado = new Empleado("Pedro",2);
        Vendedor afiliado = new Afiliado("ARamon");
        empleado.agregarAfiliado(afiliado);
        empleado.vender(2);
        afiliado.vender(4);

        String respuestaEsperada = "Pedro tiene un total de 20 puntos y categoriza como aprendiz";


        //CUANDO
        String resultado =  empleado.mostrarCategoria();


        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, resultado);
    }

    @Test
    //TODO: Case 2
    //  respuestaEsperada = "Maria tiene un total de n puntos y categoriza como novato";
    void mostrarCategoria_deberiaCategorizarElEmpleadoComoNovato() {
        //DADO
        Empleado empleado = new Empleado("Maria",1);
        empleado.vender(1);
        String respuestaEsperada = "Maria tiene un total de 5 puntos y categoriza como novato";


        //CUANDO
        String resultado =  empleado.mostrarCategoria();


        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, resultado);

    }
}