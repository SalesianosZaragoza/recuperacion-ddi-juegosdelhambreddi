package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Cafe cafe = cafeService.addCafe(cafeCreado);

		// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
        // model.addAttribute("cafes", lista);

        return this.mostrarCafes(model);
    }

	@RequestMapping("/cafeDeleteForm")
	public String cafeDeleteForm(Model model) {

		model.addAttribute("cafeBorrado", new Cafe());
		return "cafe/cafeBorrarForm";
	}

	@RequestMapping("/borrarCafe")
    public String borrarCafe(@RequestParam int cafeId, Model model) {
		cafeService.deleteCafe(cafeId);

		// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
        // model.addAttribute("cafes", lista);

        return this.mostrarCafes(model);
    }

	@RequestMapping("/cafeUpdateForm")
	public String cafeUpdateForm(Model model) {

		model.addAttribute("cafeActualizado", new Cafe());
		return "cafe/cafeForm";
	}

	@RequestMapping("/editCafe")
    public String editCafe(Cafe cafeActualizado, Model model) {
		cafeService.addCafe(cafeActualizado);

		// List<Cafe> lista = (List<Cafe>) cafeService.getAllCafes();
        // model.addAttribute("cafes", lista);

        return this.mostrarCafes(model);
    }

    
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
