package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Usuario;
import JuegosdelhambreDDI.CafeteriaAPP.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // public UsuarioService(UsuarioRepository usuarioRepository) {
    //     this.usuarioRepository = usuarioRepository;
    // }

    public List<Usuario> getAllUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario searchUsuariobyEmail(String userInput) {
        return usuarioRepository.findByEmail(userInput);
    }

}
