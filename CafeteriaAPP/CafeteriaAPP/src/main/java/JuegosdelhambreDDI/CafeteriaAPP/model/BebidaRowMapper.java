package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class BebidaRowMapper implements RowMapper<Bebida> {

    @Override
    public Bebida mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bebida bebida = new Bebida();
        bebida.setId(rs.getInt("id"));
        bebida.setNombre(rs.getString("nombre"));
        // bebida.setTipo(rs.getString("tipo"));
        // bebida.setPrecio(rs.getDouble("precio"));
        return bebida;
    }
}
