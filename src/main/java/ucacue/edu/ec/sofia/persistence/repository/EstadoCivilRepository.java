package ucacue.edu.ec.sofia.persistence.repository;


import org.springframework.stereotype.Repository;

import ucacue.edu.ec.sofia.persistence.entity.EstadoCivil;

import java.util.Optional;

@Repository
public interface EstadoCivilRepository extends BaseRepository <EstadoCivil, Long>{


    @Override
    Optional<EstadoCivil> findById(long id);

    @Override
    Optional<EstadoCivil> findByDescripcion(String descripcion);

    @Override
    EstadoCivil getOneByDescripcion(String descripcion);
}
