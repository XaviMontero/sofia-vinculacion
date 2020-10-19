package ucacue.edu.ec.sofia.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SofiaResponseDTO<T> {

    private boolean success;
    private T result;

    public SofiaResponseDTO() {
        this.success = true;
    }

    public SofiaResponseDTO(T result) {
        this.success = true;
    }

}