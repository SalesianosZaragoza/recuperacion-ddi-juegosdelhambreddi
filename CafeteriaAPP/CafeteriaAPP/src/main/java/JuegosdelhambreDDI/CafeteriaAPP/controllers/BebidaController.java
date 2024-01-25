package JuegosdelhambreDDI.CafeteriaAPP.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;


@Controller
public class BebidaController {

    @Autowired	// Se puede quitar si no se usa
	JdbcTemplate jdbcTemplate;

	@Autowired
	BebidaService bebidaService;



    @RequestMapping("/insertBebida")
	public String insertBebidaForm(Model model) {

		model.addAttribute("bebidaCreada", new Bebida());
		return "bebida/BebidaForm";
	}



	@RequestMapping("/listarBebida")
	public String listarBebida(Model model) {
		Iterable<Bebida> lista = bebidaService.getAllBebidas();

		model.addAttribute("bebida", lista);

		return "bebida/listarBebida";
	}
   


    
}
