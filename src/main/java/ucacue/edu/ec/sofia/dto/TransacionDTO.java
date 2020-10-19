package ucacue.edu.ec.sofia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacionDTO {


    private CuentaDTO cuentaDTO;

    private  TrabajadorDTO trabajadorDTO;

    private  TipoTransacionDTO tipoTransacionDTO;

    private String  fecha;

    private double monto;

    private int estado_empresa;

}
