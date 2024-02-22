package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.RefrescoService;

@Controller
public class RefrescoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	RefrescoService refrescoService;

	@Autowired
	BebidaService bebidaService;

	@RequestMapping("/insertRefresco")
	public String insertRefrescoForm(Model model) {

		model.addAttribute("refresconuevo", new Refresco());
		return "refresco/resfrescoForm";
	}

	@RequestMapping("/crearRefresco")
	public String crearRefresco(Refresco refresconuevo, Model model) {
		Refresco refresco = refrescoService.addRefresco(refresconuevo);
		List<Refresco> lista = (List<Refresco>) refrescoService.getAllRefrescos();

		model.addAttribute("refrescos", lista);

		return this.listarRefresco(model);
	}

	@RequestMapping("/listarRefresco")
	public String listarRefresco(Model model) {
		Iterable<Refresco> lista = refrescoService.getAllRefrescos();
		model.addAttribute("refrescos", lista);

		return this.mostrarRefrescos(model);
		// return "refresco/listarRefresco";
	}

	@GetMapping("/mostrar-refrescos")
	public String mostrarRefrescos(Model model) {

		String rutaCarpetaImagenes = "src/main/resources/static/ImagenesRefrescos";
		List<String> nombresImagenes = new ArrayList<>();

		File carpetaImagenes = new File(rutaCarpetaImagenes);
		File[] archivos = carpetaImagenes.listFiles();

		if (archivos != null) {
			for (File archivo : archivos) {
				nombresImagenes.add(archivo.getName());
			}
		}
		model.addAttribute("nombresImagenes", nombresImagenes);
		
		Iterable<Refresco> lista = refrescoService.getAllRefrescos();
		model.addAttribute("refrescos", lista);

		return "refresco/listarRefresco";

	}

	@RequestMapping("/borrarRefresco/{id}")
    public String borrarRefresco(@PathVariable("id") int id) {
		Refresco refresco = refrescoService.getRefrescoById(id).orElseThrow();
		List<Bebida> bebidas = bebidaService.searchBebidaByRefersco(refresco);
		for (Bebida bebida : bebidas) {
			bebidaService.deleteBebida(bebida.getId());
		}
		refrescoService.deleteRefresco(id);
        return "redirect:/mostrar-refrescos";
    }
	
	@RequestMapping("/editRefresco/{id}")
    public String editRefresco(@PathVariable("id") int id, Model model) {
		Optional<Refresco> refresco = refrescoService.getRefrescoById(id);
		model.addAttribute("refresconuevo", refresco);
        return "refresco/resfrescoForm";
    }

}
