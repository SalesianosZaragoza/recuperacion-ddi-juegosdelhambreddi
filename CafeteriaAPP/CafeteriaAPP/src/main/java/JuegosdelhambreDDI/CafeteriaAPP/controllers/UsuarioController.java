package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/Login")// GET
	public String login(Model model) {		
		model.addAttribute ("usuario", new Usuario());
		return "/Login";
	}
	
	@PostMapping("/ValidarLogin")
	public ModelAndView login(Usuario usuarioInput) {
	    Usuario usuario = usuarioService.searchUsuariobyEmail(usuarioInput.getEmail());
	    if (usuario != null && usuario.getPassword().equals(usuarioInput.getPassword())) {
	        return new ModelAndView("/index");
	    } else {
	        return new ModelAndView("/Login");
	    }
	}
	
	@RequestMapping("/index")
	public String index(String password) {
		
		return "/index";
	}
	
	
	 @RequestMapping("/crearUsuario")
	    public String crearUsuario(Usuario UsuarioCreado, Model model) {
			usuarioService.addUsuario(UsuarioCreado);
			List<Usuario> lista = (List<Usuario>) usuarioService.getAllUsuario();
			
	        model.addAttribute("cafes", lista);

	        return "/Login";
	    }
}
