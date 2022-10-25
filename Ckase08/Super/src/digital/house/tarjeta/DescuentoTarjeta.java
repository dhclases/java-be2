package digital.house.tarjeta;

public class DescuentoTarjeta {
    public static final String STAR_BANK = "Star Bank";

    public int descuento(Tarjeta tarjeta) {
        if (tarjeta.getBanco().compareTo(STAR_BANK) == 0) {
            return 20;
        } else {
            return 0;
        }
    }
}
