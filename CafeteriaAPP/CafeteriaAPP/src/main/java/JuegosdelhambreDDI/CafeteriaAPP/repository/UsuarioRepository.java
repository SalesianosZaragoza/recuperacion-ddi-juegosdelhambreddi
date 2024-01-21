package JuegosdelhambreDDI.CafeteriaAPP.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JuegosdelhambreDDI.CafeteriaAPP.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{




	
	public Usuario findByEmail(String email) ;


}
