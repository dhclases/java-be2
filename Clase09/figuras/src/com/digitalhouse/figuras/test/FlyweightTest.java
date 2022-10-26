package com.digitalhouse.figuras.test;

import com.digitalhouse.figuras.main.factory.FlyweightFactory;
import com.digitalhouse.figuras.main.model.Triangulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlyweightTest {



  @Test
    void getTrianguloConDiferentesTamano() {
    // dado

    // Cuando
      Triangulo triangulo = FlyweightFactory.obtenerTriangulo("rojo");
      triangulo.setTamano(2);

      Assertions.assertEquals(triangulo.getColor(),"rojo");
      Assertions.assertEquals(triangulo.getTamano(),2);

      Triangulo triangulo1 = FlyweightFactory.obtenerTriangulo("rojo");
      triangulo1.setTamano(4);

      Assertions.assertEquals(triangulo1.getColor(),"rojo");
      Assertions.assertEquals(triangulo1.getTamano(),4);

      Assertions.assertTrue(FlyweightFactory.trianguloMap.size()==1);

  }

}
