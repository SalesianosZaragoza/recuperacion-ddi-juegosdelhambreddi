package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClienteRowMapper implements RowMapper<Cliente>{

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setnomCliente(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setLogeado(rs.getBoolean("logeado"));
        return cliente;
    }
    
}
