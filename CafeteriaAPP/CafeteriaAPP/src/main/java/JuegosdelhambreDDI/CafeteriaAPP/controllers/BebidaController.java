package JuegosdelhambreDDI.CafeteriaAPP.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.CafeService;


@Controller
public class BebidaController {

    @Autowired	// Se puede quitar si no se usa
	JdbcTemplate jdbcTemplate;

	@Autowired
	BebidaService bebidaService;

	@Autowired
	CafeService cafeService ;


    @RequestMapping("/insertBebida")
	public String insertBebidaForm(Model model) {

		model.addAttribute("bebidaNueva", new Bebida());
		return "bebida/bebidaForm";
	}

	@RequestMapping("/crearBebida")
    public String crearBebida(Cafe cafeCreado, Model model) {
		Cafe cafe2 = cafeService.addCafe(cafeCreado);
		List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
		// Iterable<Cafe> listaCafes = cafeService.getAllCafes();
        model.addAttribute("cafes", lista);

        return "cafe/listarCafe";
    }

	@RequestMapping("/listarBebida")
	public String listarBebida(Model model) {
		Iterable<Bebida> lista = bebidaService.getAllBebidas();
		model.addAttribute("bebidas", lista);

		return "bebida/listarBebida";
	}
    
}
