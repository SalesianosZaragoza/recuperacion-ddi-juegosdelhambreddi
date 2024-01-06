package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.BebidaRowMapper;


@Repository
public class BebidaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Bebida> getAllBebidas() {
        String sql = "SELECT * FROM bebidas";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bebida.class));
    }

    public Bebida getBebidaById(int id) {
        String sql = "SELECT * FROM bebidas WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Bebida.class));
    }

    public void addBebida(Bebida bebida) {
        String sql = "INSERT INTO bebidas (nombre, precio) VALUES (?, ?)";
        jdbcTemplate.update(sql, bebida.getNombre(), bebida.getPrecio());
    }

    public void updateBebida(Bebida bebida) {
        String sql = "UPDATE bebidas SET nombre = ?, precio = ? WHERE id = ?";
        jdbcTemplate.update(sql, bebida.getNombre(), bebida.getPrecio(), bebida.getId());
    }

    public void deleteBebida(int id) {
        String sql = "DELETE FROM bebidas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Bebida> searchByNombre(String userInput) {
        return jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ?", new BebidaRowMapper(),
				userInput);
    }
}
