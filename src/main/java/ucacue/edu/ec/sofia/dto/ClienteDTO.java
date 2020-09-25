package ucacue.edu.ec.sofia.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteDTO {

    private PersonaDTO personaDTO;

    private long calificacion;

    private String descripcion;
}
