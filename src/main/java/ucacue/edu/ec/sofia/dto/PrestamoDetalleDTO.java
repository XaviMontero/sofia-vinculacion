package ucacue.edu.ec.sofia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestamoDetalleDTO {




    private PrestamoDTO prestamo;

    private String fechaAproxPago;

    private String fechaPago;

    private int detalleNumero;

    private double detalleCapitPagado;

    private double detalleSaldoPemndiente;

    private int estadoPago;

    private double mora;

    private double detalleCapital;

    private double detalleTotal;
}
