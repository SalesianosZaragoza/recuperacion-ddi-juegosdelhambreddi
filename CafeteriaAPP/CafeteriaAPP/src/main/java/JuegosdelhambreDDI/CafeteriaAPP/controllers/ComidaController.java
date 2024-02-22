package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		 String rutaCarpetaImagenes = "src/main/resources/static/ImagenesBocadillos/";
			List<String> nombresImagenes = new ArrayList<>();

			File carpetaImagenes = new File(rutaCarpetaImagenes);
	        File[] archivos = carpetaImagenes.listFiles();

			if (archivos != null) {
	            for (File archivo : archivos) {
	                nombresImagenes.add(archivo.getName());
	            }
	        }
			model.addAttribute("nombresImagenes", nombresImagenes);

		Iterable<Comida> lista = comidaService.getAllComidas();
		model.addAttribute("comidas", lista);

		return "comida/listarComida";
	}

	@RequestMapping("/borrarComida/{id}")
	public String borrarComida(@PathVariable("id") int id, Model model) {
		comidaService.deleteComida(id);

		return "redirect:/listarComida";
	}

	
	@RequestMapping("/editComida/{id}")
    public String editComida(@PathVariable("id") int id, Model model) {
		Optional<Comida> comida = comidaService.getComidaById(id);
		model.addAttribute("comidaNueva", comida);
        return "comida/comidaForm";
    }
}
