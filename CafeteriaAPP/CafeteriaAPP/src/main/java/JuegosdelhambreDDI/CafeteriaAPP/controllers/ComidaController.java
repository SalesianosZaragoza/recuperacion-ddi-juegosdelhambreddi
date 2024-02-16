package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.service.ComidaService;

@Controller
public class ComidaController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ComidaService comidaService;

	// @RequestMapping("/insertComida")
	// public String insertComidaForm(Model model) {

	// model.addAttribute("comidaNueva", new Comida());
	// return "comida/comidaForm";
	// }

	// @RequestMapping("/listarComida")
	// public String listarComida(Model model) {
	// Iterable<Comida> lista = comidaService.getAllComidas();
	// model.addAttribute("comidas", lista);

	// return "comida/listarComida";
	// }

	// Comida

	@RequestMapping("/insertComida")
	public String insertComidaForm(Model model) {

		model.addAttribute("comidaNueva", new Comida());
		return "comida/comidaForm";
	}

	@RequestMapping("/crearComida")
	public String crearComida(Comida comidaNueva, Model model) {
		Comida comida = comidaService.addComida(comidaNueva);

		return this.listarComida(model);
	}

	@RequestMapping("/crearComidaNueva")
	public String crearComidaNueva(Comida comidaNueva, Model model) {
		// System.out.println("crearComidaNueva");
		Comida comida = comidaService.addComida(comidaNueva);
		Iterable<Comida> lista = comidaService.getAllComidas();
		model.addAttribute("comidas", lista);

		return this.listarComida(model);
	}

	@RequestMapping("/listarComida")
	public String listarComida(Model model) {
		Iterable<Comida> lista = comidaService.getAllComidas();
		model.addAttribute("comidas", lista);

		return "comida/listarComida";
	}

	

	@RequestMapping("/borrarComida")
	public String borrarComida(@RequestParam int comidaId, Model model) {
		comidaService.deleteComida(comidaId);

		return this.listarComida(model);
	}

}
