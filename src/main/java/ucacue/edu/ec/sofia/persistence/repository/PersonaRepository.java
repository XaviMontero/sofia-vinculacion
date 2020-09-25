package ucacue.edu.ec.sofia.persistence.repository;


import ucacue.edu.ec.sofia.persistence.entity.Persona;

import java.util.Optional;

public interface PersonaRepository extends PleopleRepository <Persona, Long>  {
    @Override
    Optional<Persona> findByCedula(String cedula);

    @Override
    Persona getOneByCedula(String cedula);
}
