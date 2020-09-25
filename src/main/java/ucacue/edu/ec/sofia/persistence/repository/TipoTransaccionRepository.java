package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.stereotype.Repository;

import ucacue.edu.ec.sofia.persistence.entity.TipoTransacion;

import java.util.Optional;

@Repository
public interface TipoTransaccionRepository extends  BaseRepository <TipoTransacion, Long>{

    @Override
    TipoTransacion getOneByDescripcion(String descripcion);

    @Override
    Optional<TipoTransacion> findById(long id);

    @Override
    Optional<TipoTransacion> findByDescripcion(String descripcion);
}
