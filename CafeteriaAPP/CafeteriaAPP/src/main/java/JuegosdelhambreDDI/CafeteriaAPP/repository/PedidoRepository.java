package JuegosdelhambreDDI.CafeteriaAPP.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;



@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findBynumPedido(int numPedido) ;

    // Optional<Cafe> findByNomProducto(String nomProducto)
    
    
}
