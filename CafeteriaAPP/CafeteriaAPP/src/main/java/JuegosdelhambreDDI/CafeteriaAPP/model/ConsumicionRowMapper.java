package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class ConsumicionRowMapper implements RowMapper<Consumicion>{

    @Override
    public Consumicion mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Consumicion consumicion = new Consumicion();
        consumicion.setId(rs.getInt("id"));
        consumicion.setNombre(rs.getString("nombre"));
        consumicion.setPrecio(rs.getDouble("precio"));
        return consumicion;
    }
    
}
