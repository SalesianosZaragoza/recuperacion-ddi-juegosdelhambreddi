package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Usuario;
import JuegosdelhambreDDI.CafeteriaAPP.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/Register")
	public String crearUsuario(Model model) {
		model.addAttribute("usuarioCreado", new Usuario());
		return "/Register";
	}
	
	@RequestMapping("/Login")
	public String login() {
		
		return "/Login";
	}
	
	
	 @RequestMapping("/crearUsuario")
	    public String crearUsuario(Usuario UsuarioCreado, Model model) {
			usuarioService.addUsuario(UsuarioCreado);
			List<Usuario> lista = (List<Usuario>) usuarioService.getAllUsuario();
			
	        model.addAttribute("cafes", lista);

	        return "/Login";
	    }
}
