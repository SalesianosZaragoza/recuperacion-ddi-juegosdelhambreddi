package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.model.Consumicion;
import JuegosdelhambreDDI.CafeteriaAPP.service.BebidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.ComidaService;
import JuegosdelhambreDDI.CafeteriaAPP.service.ConsumicionService;

@Controller
@RequestMapping("/consumicion")
public class ConsumicionController {

    @Autowired
    private ConsumicionService consumicionService;

    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private ComidaService comidaService;

    @RequestMapping("")
    public String getAllConsumiciones(Model model) {
        List<Consumicion> consumiciones = consumicionService.getAllConsumiciones();
        model.addAttribute("consumiciones", consumiciones);
        return "consumicion/consumicion-list";
    }

    @RequestMapping("/add")
    public String addConsumicion(Model model) {
        Consumicion consumicion = new Consumicion();
        Iterable<Bebida> bebidas = bebidaService.getAllBebidas();
        Iterable<Comida> comidas = comidaService.getAllComidas();
        model.addAttribute("consumicionNueva", consumicion);
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("comidas", comidas);
        return "consumicion/consumicion-form";
    }

    @RequestMapping("/save")
    public String saveConsumicion(@ModelAttribute("consumicionNueva") Consumicion consumicion, Model model) {
        String nombreConsumicion = this.getNombreConsumicion(
                consumicion.getBebida().getCafe().getNomcafe(), 
                consumicion.getBebida().getRefresco().getNomRefresco(), 
                consumicion.getComida().getNomComida()
            ); 
        consumicion.setNombreConsumicion(nombreConsumicion);
        double precioTotal = consumicion.getBebida().getPrecio() + consumicion.getComida().getPrecio(); //+ consumicion.getComida().getPrecio();
        consumicion.setPrecio(precioTotal);
        consumicionService.addConsumicion(consumicion);
        
        return this.getAllConsumiciones(model);
    }

    private String getNombreConsumicion(String cafe, String refresco, String comida) {
        String nombreConsumicion = "";
        String separador = "";
        //consumicion.getBebida().getCafe().getNomcafe();//+ " - " + consumicion.getBebida().getRefresco().getNomRefresco() + " - " + 
        if ( ( !cafe.isEmpty() ) && ( !cafe.equals("nulo") ) ){
            nombreConsumicion = cafe;
            separador = " - ";
        }
        if ( ( !refresco.isEmpty() ) && ( !refresco.equals("nulo") ) ){
            nombreConsumicion = nombreConsumicion + separador + refresco;
            separador = " - ";
        }
        if ( ( !comida.isEmpty() ) && ( !comida.equals("nulo") ) ){
            nombreConsumicion = nombreConsumicion + separador + comida;
        }else if ( nombreConsumicion.equals("") )
            nombreConsumicion = "Sin Nombre";
        return nombreConsumicion;
    }

    @RequestMapping("/edit/{id}")
    public String editConsumicion(@PathVariable("id") int id, Model model) {
        Optional<Consumicion> consumicion = consumicionService.getConsumicionById(id);
        Iterable<Bebida> bebidas = bebidaService.getAllBebidas();
        Iterable<Comida> comidas = comidaService.getAllComidas();
        model.addAttribute("consumicion", consumicion);
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("comidas", comidas);
        return "consumicion/consumicion-form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteConsumicion(@PathVariable("id") int id) {
        consumicionService.deleteConsumicion(id);
        return "redirect:/consumicion";
    }







    

}
