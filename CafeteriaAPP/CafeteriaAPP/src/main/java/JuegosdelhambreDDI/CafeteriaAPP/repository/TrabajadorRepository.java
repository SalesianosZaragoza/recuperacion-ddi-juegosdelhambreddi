package JuegosdelhambreDDI.CafeteriaAPP.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Trabajador;


@Repository
public interface TrabajadorRepository extends CrudRepository<Trabajador, Integer>{

    public List<Trabajador> findBynomTrabajador(String nomTrabajador) ;

    // Optional<Trabajador> findByNomTrabajador(String nomTrabajador)


}
