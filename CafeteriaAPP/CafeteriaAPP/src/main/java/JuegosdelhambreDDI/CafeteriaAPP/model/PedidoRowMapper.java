package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class PedidoRowMapper implements RowMapper<Pedido>{

    @Override
    public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Pedido pedido = new Pedido();
        pedido.setNumPedido(rs.getInt("numPedido"));
        return pedido;
    }
    
}
