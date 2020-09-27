package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucacue.edu.ec.sofia.persistence.entity.PrestamoDetalle;

import java.util.List;

@Repository
public interface PrestamoDetalleRepository extends JpaRepository<PrestamoDetalle, Long> {
    @Override
    List <PrestamoDetalle> findAll();


}
