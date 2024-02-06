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
	
	@RequestMapping("/Login")
	public String login() {		
		
		return "/Login";
	}
	
	@PostMapping("/ValidarLogin")
	    public ModelAndView login(@RequestParam String email, @RequestParam String password) {
	        Usuario usuario = usuarioService.searchUsuariobyEmail(email);
	        if (usuario != null && usuario.getPassword().equals(password)) {
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
