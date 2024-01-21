package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;


@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

    //busca por cafe
    public List<Bebida> findBycafe(String cafe) ;

    //busca por refresco
    public List<Bebida> findByrefresco(String refresco) ;

    // Optional<Bebida> findByNomProducto(String nomProducto)
 
}
