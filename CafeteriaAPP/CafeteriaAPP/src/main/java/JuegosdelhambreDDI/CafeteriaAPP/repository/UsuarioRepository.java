package JuegosdelhambreDDI.CafeteriaAPP.repository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.Usuario;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import JuegosdelhambreDDI.CafeteriaAPP.model.UsuarioRowMapper;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{



	public List<Usuario> findAll() {
		return jdbcTemplate.query("select * from usuario", new UsuarioRowMapper());
	}

	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from usuario where id=?", id);
	}

	public int insert(Usuario usuario) {
		return jdbcTemplate.update("insert into usuario (id, username, password, email) " + "values(?,  ?, ?, ?)",
				new Object[] { usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail() });
	}

	public int update(Usuario usuario) {
		return jdbcTemplate.update("update usuario " + " set username = ?, password = ?, email = ? " + " where id = ?",
				new Object[] { usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), usuario.getId() });
	}

	public Usuario findById(Long id) {
		return jdbcTemplate.queryForObject("select * from usuario where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}
	
	public Usuario findByEmail(String email) ;


}
