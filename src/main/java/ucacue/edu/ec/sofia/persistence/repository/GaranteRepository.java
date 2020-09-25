package ucacue.edu.ec.sofia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucacue.edu.ec.sofia.persistence.entity.Garante;


import java.util.Optional;

@Repository
public interface GaranteRepository extends JpaRepository<Garante, Long> {

    Optional<Garante> findByPersonaCedula(String cedula);

    Garante getOneByPersonaCedula(String cedula);
}
