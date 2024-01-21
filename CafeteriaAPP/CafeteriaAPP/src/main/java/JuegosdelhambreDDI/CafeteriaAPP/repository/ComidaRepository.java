package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;


@Repository
public interface ComidaRepository  extends CrudRepository<Comida, Integer>{
    
    public List<Comida> findBynomComida(String nomComida) ;

    // Optional<Cliente> findByNomCliente(String nomCliente)
   
}
