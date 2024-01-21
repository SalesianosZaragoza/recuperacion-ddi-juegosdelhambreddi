package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    public List<Cliente> findBynomCliente(String nomCliente) ;

    // Optional<Cliente> findByNomCliente(String nomCliente)
  
    

}
