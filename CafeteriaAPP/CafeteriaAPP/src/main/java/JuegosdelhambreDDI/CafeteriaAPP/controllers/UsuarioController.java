package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		String password = "";
		try {
			password = generarHash(usuarioInput.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("Error al crear el hash de la contraseña\n" + e.getMessage());
		}
		if (usuario != null && usuario.getPassword().equals(password)) {
			Iterable<Usuario> usuarios = usuarioService.getAllUsuario();
			for (Usuario usuario2list : usuarios) {
				usuario2list.setEsLogin(false);
			}
			usuario.setEsLogin(true);
			usuarioService.addUsuario(usuario);
			if (usuario.getEsCliente()) 
				return new ModelAndView("/indexClient");
			else
				return new ModelAndView("/index");
		} else {
			return new ModelAndView("/Login");
		}
	}
	
	@RequestMapping("/indexClient")
	public String PaginaindexWorker(Model model) {
		return "/indexClient";
	}
	@RequestMapping("/index")
	public String Paginaindex(Model model) {
		return "/index";
	}
	@RequestMapping("/")
	public String index(Model model) {
		return this.Paginaindex(model);
	}
	
	
	@RequestMapping("/crearUsuario")
		public String crearUsuario(Usuario UsuarioCreado, Model model) {
			String contraseñaSinHash = UsuarioCreado.getPassword();
			try {
				String PasswordHash = generarHash(contraseñaSinHash);// Generar el HASH con cifrado SHA-256

				UsuarioCreado.setPassword(PasswordHash);

				usuarioService.addUsuario(UsuarioCreado);

				// List<Usuario> lista = (List<Usuario>) usuarioService.getAllUsuario();
				// model.addAttribute("cafes", lista);

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				System.out.println("Error al crear el hash de la contraseña\n" + e.getMessage());
			}

			// UsuarioCreado.setPassword(contraseñaSinHash);
			// usuarioService.addUsuario(UsuarioCreado);

	        return "/Login";
	    }

		private String generarHash(String contraseña) throws NoSuchAlgorithmException {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(contraseña.getBytes(StandardCharsets.UTF_8));
		
			// Convierte los bytes del hash a una representación hexadecimal
			StringBuilder hexHash = new StringBuilder();
			for (byte b : hashBytes) {
				hexHash.append(String.format("%02x", b));
			}
		
			return hexHash.toString();
		}
}
