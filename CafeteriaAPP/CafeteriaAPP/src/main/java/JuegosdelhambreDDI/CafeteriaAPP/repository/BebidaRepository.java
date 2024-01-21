package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;


@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

    //busca por cafe
    public List<Bebida> findBycafe(Cafe cafe) ;

    //busca por refresco
    public List<Bebida> findByrefresco(Refresco refresco) ;

    // Optional<Bebida> findByNomProducto(String nomProducto)
 
}
