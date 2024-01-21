package JuegosdelhambreDDI.CafeteriaAPP.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;


import java.util.List;



@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findBynomProducto(String nomProducto) ;

    // Optional<Cafe> findByNomProducto(String nomProducto)
    
    
}
