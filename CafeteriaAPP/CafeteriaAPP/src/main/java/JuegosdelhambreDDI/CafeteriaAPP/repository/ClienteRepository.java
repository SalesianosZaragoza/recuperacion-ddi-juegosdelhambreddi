package JuegosdelhambreDDI.CafeteriaAPP.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cliente;
import JuegosdelhambreDDI.CafeteriaAPP.model.ClienteRowMapper;


@Repository
public class ClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> getAllClientes() {
        String sql = "SELECT * FROM clientes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cliente.class));
    }

    public Cliente getClienteById(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Cliente.class));
    }

    public Cliente addCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, apellidos, email, telefono) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getNombre(), cliente.getApellido(), cliente.getId(), cliente.getLogeado());
        return cliente;
    }


    public Cliente updateCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, apellidos = ?, email = ?, telefono = ? WHERE id = ?";
        jdbcTemplate.update(sql, cliente.getNombre(), cliente.getApellido(), cliente.getId(), cliente.getLogeado());
        return cliente;
    }

    public void deleteCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Cliente> searchByNombre(String userInput) {
        return jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ?", new ClienteRowMapper(),
                userInput);
    }


}
