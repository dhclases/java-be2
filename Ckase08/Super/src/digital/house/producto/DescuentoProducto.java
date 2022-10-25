package digital.house.producto;

public class DescuentoProducto {
    public int descuento(Producto unproducto) {
        if (unproducto.getTipo().compareTo("lata") == 0) {
            return 10;
        } else {
            return 0;
        }
    }
}
