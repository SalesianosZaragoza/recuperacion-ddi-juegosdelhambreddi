package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.CafeRowMapper;



@Repository
public class CafeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cafe> getAllCafes() {
        String sql = "SELECT * FROM cafes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cafe.class));
    }

    public Cafe getCafeById(int id) {
        String sql = "SELECT * FROM cafes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Cafe.class));
    }

    public Cafe addCafe(Cafe cafe) {
        String sql = "INSERT INTO cafes (nombre, precio) VALUES (?, ?)";
        jdbcTemplate.update(sql, cafe.getNomProducto(), cafe.getPrecio());
        return cafe;
    }

    public Cafe updateCafe(Cafe cafe) {
        String sql = "UPDATE cafes SET nombre = ?, precio = ? WHERE id = ?";
        jdbcTemplate.update(sql, cafe.getNomProducto(), cafe.getPrecio(), cafe.getId());
        return cafe;
    }

    public void deleteCafe(int id) {
        String sql = "DELETE FROM cafes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Cafe> searchByNombre(String userInput) {
        return jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ?", new CafeRowMapper(),
                userInput);
    
}
}

