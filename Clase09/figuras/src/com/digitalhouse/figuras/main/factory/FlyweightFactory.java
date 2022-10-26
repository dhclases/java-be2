package com.digitalhouse.figuras.main.factory;

import com.digitalhouse.figuras.main.model.Triangulo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    public static final Map<String, Triangulo> trianguloMap = new HashMap<>();

    public static Triangulo obtenerTriangulo(String color, int tam){
        String key = color + tam
        Triangulo triangulo = trianguloMap.get(key);
        if(triangulo == null){
            triangulo = new Triangulo(color);
            triangulo.setTamano(tam);
            trianguloMap.put(color,triangulo);
        }
        return triangulo;
    }
}
