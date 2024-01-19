package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;



@Repository
public interface CafeRepository extends CrudRepository<Cafe, Integer>{

    public List<Cafe> findBynomProducto(String nomProducto) ;

    // Optional<Cafe> findByNomProducto(String nomProducto)

}

