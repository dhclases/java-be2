import digital.house.producto.DescuentoProducto;
import digital.house.producto.DescuentoVolumen;
import digital.house.producto.Producto;
import digital.house.tarjeta.DescuentoTarjeta;
import digital.house.tarjeta.Tarjeta;

public class ProcesadorDescuento {
    private DescuentoProducto descuentoProducto;
    private DescuentoTarjeta descuentoTarjeta;
    private DescuentoVolumen descuentoVolumen;

    public ProcesadorDescuento() {
        descuentoProducto = new DescuentoProducto();
        descuentoTarjeta = new DescuentoTarjeta();
        descuentoVolumen = new DescuentoVolumen();
    }

    public int descuento (Tarjeta tarjeta, Producto producto, int cantidad){
        int descuento = 0;
        descuento = descuento + descuentoVolumen.descuento(cantidad);
        descuento = descuento + descuentoProducto.descuento(producto);
        descuento = descuento + descuentoTarjeta.descuento(tarjeta);
        return descuento;
    }
}
