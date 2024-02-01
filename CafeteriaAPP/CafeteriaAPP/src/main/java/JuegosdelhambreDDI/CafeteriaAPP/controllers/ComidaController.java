package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.service.ComidaService;

@Controller
public class ComidaController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ComidaService comidaService;

    
    @RequestMapping("/insertComida")
	public String insertComidaForm(Model model) {

		model.addAttribute("comidaNueva", new Comida());
		return "comida/comidaForm";
	}
   
    
	@RequestMapping("/listarComida")
	public String listarComida(Model model) {
		Iterable<Comida> lista = comidaService.getAllComidas();
		model.addAttribute("comidas", lista);

		return "comida/listarComida";
	}
    















    
}
