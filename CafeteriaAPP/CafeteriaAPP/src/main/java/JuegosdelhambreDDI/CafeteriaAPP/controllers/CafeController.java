package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.CafeService;

@Controller
public class CafeController {
    

    @Autowired
	CafeService cafeService;

	@Autowired
	BebidaService bebidaService;
    
	@RequestMapping("/cafeForm")
	public String insertCafeForm(Model model) {

		model.addAttribute("cafeCreado", new Cafe());
		return "cafe/cafeForm";
	}

    @RequestMapping("/crearCafe")
    public String crearCafe(Cafe cafeCreado, Model model) {
		Cafe cafe = cafeService.addCafe(cafeCreado);

		// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
        // model.addAttribute("cafes", lista);

        return this.mostrarCafes(model);
    }

	@RequestMapping("/borrarCafe/{id}")// /borrarCafe/{id}
    public String borrarCafe(@PathVariable("id") int id) {
		Cafe cafe = cafeService.getCafeById(id).orElseThrow();
		List<Bebida> bebidas = bebidaService.searchBebidaByCafe(cafe);
		for (Bebida bebida : bebidas) {
			bebidaService.deleteBebida(bebida.getId());
		}
        cafeService.deleteCafe(id);
        return "redirect:/mostrar-cafe";
    }

	@RequestMapping("/editCafe/{id}")
    public String editCafe(@PathVariable("id") int id, Model model) {
        Optional<Cafe> cafe = cafeService.getCafeById(id);
        model.addAttribute("cafeCreado", cafe);
        return "cafe/cafeForm";
    }

    

	// @RequestMapping("/borrarCafe")
    // public String borrarCafe(@RequestParam int cafeId, Model model) {
	// 	cafeService.deleteCafe(cafeId);

	// 	// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
    //     // model.addAttribute("cafes", lista);

    //     return this.mostrarCafes(model);
    // }
	// @RequestMapping("/cafeUpdateForm")
	// public String cafeUpdateForm(Model model) {

	// 	model.addAttribute("cafeActualizado", new Cafe());
	// 	return "cafe/cafeForm";
	// }

	// @RequestMapping("/editCafe")
    // public String editCafe(Cafe cafeActualizado, Model model) {
	// 	cafeService.addCafe(cafeActualizado);

	// 	// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
    //     // model.addAttribute("cafes", lista);

    //     return this.mostrarCafes(model);
    // }

    
	@RequestMapping("/listarCafe")
	public String listarCafe(Model model) {
		Iterable<Cafe> lista = cafeService.getAllCafes();

		model.addAttribute("cafes", lista);

		return this.mostrarCafes(model);
	}

	@GetMapping("/mostrar-cafe")
    public String mostrarCafes(Model model) {

        String rutaCarpetaImagenes = "src/main/resources/static/ImagenesCafes/";
		List<String> nombresImagenes = new ArrayList<>();

		File carpetaImagenes = new File(rutaCarpetaImagenes);
        File[] archivos = carpetaImagenes.listFiles();

		if (archivos != null) {
            for (File archivo : archivos) {
                nombresImagenes.add(archivo.getName());
            }
        }
		model.addAttribute("nombresImagenes", nombresImagenes);
		
		Iterable<Cafe> lista = cafeService.getAllCafes();
		model.addAttribute("cafes", lista);
		
		return "cafe/listarCafe";

    }

}
