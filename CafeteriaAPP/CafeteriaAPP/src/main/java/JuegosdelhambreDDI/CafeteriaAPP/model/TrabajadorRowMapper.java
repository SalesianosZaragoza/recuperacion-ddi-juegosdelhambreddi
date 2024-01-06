package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;



public class TrabajadorRowMapper implements RowMapper<Trabajador>{

    @Override
    public Trabajador mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Trabajador trabajador = new Trabajador();
        trabajador.setId(rs.getInt("id"));
        trabajador.setNombre(rs.getString("nombre"));
        trabajador.setApellidos(rs.getString("apellidos"));
        return trabajador;
    }
    
}
