package JuegosdelhambreDDI.CafeteriaAPP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Consumicion;

@Repository
public interface ConsumicionRepository extends CrudRepository<Consumicion, Integer>  {
 
    // public List<Consumicion> findBynombreConsumicion(String nombreConsumicion) ;
}
