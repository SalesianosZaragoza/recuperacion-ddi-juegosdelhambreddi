package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.service.CafeService;

@Controller
public class CafeController {
    

    @Autowired
	CafeService cafeService;
    
	@RequestMapping("/cafeForm")
	public String insertCafeForm(Model model) {

		model.addAttribute("cafeCreado", new Cafe());
		return "cafe/cafeForm";
	}

    @RequestMapping("/crearCafe")
    public String crearCafe(Cafe cafeCreado, Model model) {
		cafeService.addCafe(cafeCreado);
		List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
		
        model.addAttribute("cafes", lista);

        return "cafe/listarCafe";
    }
    
	@RequestMapping("/listarCafe")
	public String listarCafe(Model model) {
		Iterable<Cafe> lista = cafeService.getAllCafes();

		model.addAttribute("cafes", lista);

		return "cafe/listarCafe";
	}
}
