package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.stereotype.Repository;

import ucacue.edu.ec.sofia.persistence.entity.TipoCuenta;

import java.util.Optional;

@Repository
public interface TipoCuentaRepository extends BaseRepository <TipoCuenta, Long> {

    @Override
    Optional<TipoCuenta> findById(long id);

    @Override
    Optional<TipoCuenta> findByDescripcion(String descripcion);

    @Override
    TipoCuenta getOneByDescripcion(String descripcion);
}
