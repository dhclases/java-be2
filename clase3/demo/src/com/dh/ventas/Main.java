package com.dh.ventas;

import com.dh.ventas.model.Afiliado;
import com.dh.ventas.model.Empleado;
import com.dh.ventas.model.Vendedor;

public class Main {

    public static void main(String[] args) {
        Empleado emp1 = new Empleado("EPedro",2);
        emp1.vender(2);

        Empleado emp2 = new Empleado("EMaria",1);
        emp2.vender(2);

        Vendedor afi1 = new Afiliado("ARamon");
        afi1.vender(4);

        Vendedor afi2 = new Afiliado("APepe");
        afi2.vender(4);

        Vendedor afi3 = new Afiliado("ASantiago");
        afi3.vender(4);

        emp1.agregarAfiliado(afi1);

        System.out.println(emp1.getNombreCategorias());
        System.out.println(emp2.getNombreCategorias());
        System.out.println(afi1.getNombreCategorias());


    }
}
