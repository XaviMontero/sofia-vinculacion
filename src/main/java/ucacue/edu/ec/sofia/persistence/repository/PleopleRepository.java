package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface PleopleRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    public Optional<T> findByCedula(String cedula);
    public T getOneByCedula (String cedula);

}
