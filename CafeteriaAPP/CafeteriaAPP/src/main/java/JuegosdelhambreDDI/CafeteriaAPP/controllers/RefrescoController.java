package JuegosdelhambreDDI.CafeteriaAPP.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;
import JuegosdelhambreDDI.CafeteriaAPP.service.RefrescoService;

@Controller
public class RefrescoController {


    @Autowired
	JdbcTemplate jdbcTemplate;

    @Autowired
    RefrescoService refrescoService;



    @RequestMapping("/insertRefresco")
	public String insertRefrescoForm(Model model) {

		model.addAttribute("refresconuevo", new Refresco());
		return "refresco/RefrescoForm";
	}


    @RequestMapping("/crearRefresco")
    public String crearRefresco(Refresco refresconuevo, Model model) {
		Refresco refresco = refrescoService.addRefresco(refresconuevo);
		List<Refresco> lista = (List<Refresco>) refrescoService.getAllRefrescos();
		
        model.addAttribute("refrescos", lista);

        return "refresco/crearRefresco";
    }
    
	@RequestMapping("/listarRefresco")
	public String listarRefresco(Model model) {
		Iterable<Refresco> lista = refrescoService.getAllRefrescos();
		model.addAttribute("refrescos", lista);

		return "refresco/listarRefresco";
	}



}
