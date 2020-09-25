package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.stereotype.Repository;

import ucacue.edu.ec.sofia.persistence.entity.Sucursal;

import java.util.Optional;

@Repository
public interface SucursalRepository extends  BaseRepository <Sucursal, Long>{
    @Override
    Optional<Sucursal> findById(long id);

    @Override
    Optional<Sucursal> findByDescripcion(String descripcion);

    @Override
    Sucursal getOneByDescripcion(String descripcion);
}
