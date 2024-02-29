package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;


@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

    public List<Bebida> findBynomProducto(String nomProducto) ;

    // Optional<Bebida> findByNomProducto(String nomProducto)
 
}
