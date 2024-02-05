package JuegosdelhambreDDI.CafeteriaAPP.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.CafeService;
import JuegosdelhambreDDI.CafeteriaAPP.service.RefrescoService;


@Controller
public class BebidaController {

    @Autowired	// Se puede quitar si no se usa
	JdbcTemplate jdbcTemplate;

	@Autowired
	BebidaService bebidaService;

	@Autowired
	CafeService cafeService ;

	@Autowired
	RefrescoService refrescoService;

    @RequestMapping("/insertBebida")
	public String insertBebidaForm(Model model) {

		model.addAttribute("bebidaNueva", new Bebida());
		Iterable<Cafe> lista = cafeService.getAllCafes();
		model.addAttribute("cafes", lista);
		Iterable<Refresco> listaRefresco = refrescoService.getAllRefrescos();
		model.addAttribute("refrescos", listaRefresco);
		return "bebida/bebidaForm";
	}

	@RequestMapping("/crearBebida")
    public String crearBebida(Bebida bebidaCreada, Model model) {
		if(!"nulo".equals(bebidaCreada.getCafe().getNomcafe()) && !"nulo".equals(bebidaCreada.getRefresco().getNomRefresco())) {
			System.out.println("Se ha seleccionado cafe y refresco");
			return this.insertBebidaForm(model);
		}
		Bebida bebida = bebidaService.addBebida(bebidaCreada);
		model.addAttribute("bebidaNueva", bebida);
		return this.listarBebida(model);
    }

	@RequestMapping("/listarBebida")
	public String listarBebida(Model model) {
		Iterable<Bebida> lista = bebidaService.getAllBebidas();
		model.addAttribute("bebidas", lista);

		return "bebida/listarBebida";
	}
    
}
