package ucacue.edu.ec.sofia.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstadoCuentaDTO {

    private String fecha;
    private String descripcion;
    private Double monto;
    private Double total;

}
