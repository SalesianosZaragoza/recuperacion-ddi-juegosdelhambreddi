package JuegosdelhambreDDI.CafeteriaAPP.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ComidaRowMapper implements RowMapper<Comida>{

    @Override
    public Comida mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Comida comida = new Comida();
        comida.setId(rs.getInt("id"));
        comida.setNomComida(rs.getString("nomProducto"));
        // comida.setCantidad(rs.getInt("cantidad"));
        comida.setPrecio(rs.getDouble("precio"));
        return comida;
    }






}