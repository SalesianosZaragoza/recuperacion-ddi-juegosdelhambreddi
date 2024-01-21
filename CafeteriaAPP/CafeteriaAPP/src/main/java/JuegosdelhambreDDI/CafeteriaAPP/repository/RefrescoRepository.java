package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;


@Repository
public interface RefrescoRepository extends CrudRepository<Refresco, Integer>{
    public List<Refresco> findBynomProducto(String nomProducto) ;

    // Optional<Refresco> findByNomProducto(String nomProducto)

    
}
