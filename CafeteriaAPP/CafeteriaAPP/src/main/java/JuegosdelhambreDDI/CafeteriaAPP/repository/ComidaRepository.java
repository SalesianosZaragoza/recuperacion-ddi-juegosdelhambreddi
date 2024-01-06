package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.model.ComidaRowMapper;

@Repository
public class ComidaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Comida> getAllComidas() {
        String sql = "SELECT * FROM comidas";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comida.class));
    }

    public Comida getComidaById(Long id) {
        String sql = "SELECT * FROM comidas WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Comida.class));
    }

    public Comida addComida(Comida comida) {
        String sql = "INSERT INTO comidas (nomProducto, cantidad, precio) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comida.getNomProducto(), comida.getCantidad(), comida.getPrecio(), comida.getId());
        return comida;
    }

    public Comida updateComida(Comida comida) {
        String sql = "UPDATE comidas SET nomProducto = ?, cantidad = ?, precio = ? WHERE id = ?";
        jdbcTemplate.update(sql, comida.getNomProducto(), comida.getCantidad(), comida.getPrecio(), comida.getId());
        return comida;
    }

    public void deleteComida(Long id) {
        String sql = "DELETE FROM comidas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Comida> searchByNombre(String userInput) {
        return jdbcTemplate.query("SELECT * FROM comidas WHERE nombre = ?", new ComidaRowMapper(),
                userInput);
    }
}
