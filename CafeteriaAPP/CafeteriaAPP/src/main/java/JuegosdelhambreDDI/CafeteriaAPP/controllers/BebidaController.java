package JuegosdelhambreDDI.CafeteriaAPP.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/CrearBebidaByDefault")
	public String CrearBebidaByDefault(Model model) {
		List<Refresco> listaRefrescos = (List)refrescoService.getAllRefrescos();
		listaRefrescos.remove(0);
		List<Cafe> listaCafes = (List) cafeService.getAllCafes();
		listaCafes.remove(0);
		
		for (Cafe cafe : listaCafes) {
			Bebida bebida = new Bebida();
			bebida.setCafe(cafe);
			bebida.setRefresco(refrescoService.getRefrescoById(0).orElse(null));
			bebida.setPrecio(cafe.getPrecio());
			bebidaService.addBebida(bebida);
		}
		for (Refresco refresco : listaRefrescos) {
			Bebida bebida = new Bebida();
			bebida.setRefresco(refresco);
			bebida.setCafe(cafeService.getCafeById(0).orElse(null));
			bebida.setPrecio(refresco.getPrecio());
			bebidaService.addBebida(bebida);
		}
		return this.listarBebida(model);
	}
    
	@RequestMapping("/borrarBebida/{id}") // /borrarBebida/{id}
    public String borrarBebida(@PathVariable("id") int id) {
		bebidaService.deleteBebida(id);
        return "redirect:/listarBebida";
    }
	
	@RequestMapping("/editBebida/{id}")
    public String editBebida(@PathVariable("id") int id, Model model) {
		Optional<Bebida> bebida = bebidaService.getBebidaById(id);
        model.addAttribute("bebidaNueva", bebida);
		Iterable<Cafe> lista = cafeService.getAllCafes();
		model.addAttribute("cafes", lista);
		Iterable<Refresco> listaRefresco = refrescoService.getAllRefrescos();
		model.addAttribute("refrescos", listaRefresco);
        return "bebida/bebidaForm";
    }

	// @RequestMapping("/borrarBebida")
	// public String borrarBebida(@RequestParam int bebidaId, Model model) {
	// 	bebidaService.deleteBebida(bebidaId);
	// 	return this.listarBebida(model);
	// }
}
