package JuegosdelhambreDDI.CafeteriaAPP.model;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class CafeRowMapper implements RowMapper<Cafe> {

    @Override
    public Cafe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cafe cafe = new Cafe();
        cafe.setId(rs.getInt("id"));
        cafe.setNomProducto(rs.getString("nomProducto"));
        cafe.setCantidad(rs.getInt("cantidad"));
        cafe.setPrecio(rs.getDouble("precio"));
        return cafe;
    }
    
}
