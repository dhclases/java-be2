package digital.house.producto;

public class DescuentoVolumen {
    public int descuento(int cuantos) {
        if (cuantos > 11) {
            return 15;
        } else {
            return 0;
        }
    }
}
