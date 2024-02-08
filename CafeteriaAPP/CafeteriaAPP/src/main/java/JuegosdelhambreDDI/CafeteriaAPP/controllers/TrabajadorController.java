package JuegosdelhambreDDI.CafeteriaAPP.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;
import JuegosdelhambreDDI.CafeteriaAPP.model.Trabajador;
import JuegosdelhambreDDI.CafeteriaAPP.service.TrabajadorService;
import JuegosdelhambreDDI.CafeteriaAPP.service.PedidoService;


public class TrabajadorController {


    @Autowired
    private TrabajadorService trabajadorService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/trabajadores")
    public String getTrabajadores(Model model) {
        List<Trabajador> trabajadores = trabajadorService.getAllTrabajador();
        model.addAttribute("trabajadores", trabajadores);
        return "trabajadores";
    }

    @RequestMapping("/pedidos")
    public String getPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }

   /*  @RequestMapping("/pedidos/pendientes")
    public String getPedidosPendientes(Model model) {
        List<Pedido> pedidos = pedidoService.getPedidosPendientes();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }


    */

    @RequestMapping("/pedidos/eliminar")
    public String eliminarPedido(Model model, int id) {
        pedidoService.deletePedido(id);;
        return "redirect:/pedidos/pendientes";
    }

    @RequestMapping("/pedidos/crear")
    public String crearPedido(Model model, Pedido pedido) {
        pedidoService.addPedido(pedido);
        return "redirect:/pedidos/pendientes";
    }

   /* @RequestMapping("/pedidos/editar")
    public String editarPedido(Model model, Pedido pedido) {
        pedidoService.editarPedido(pedido);
        return "redirect:/pedidos/pendientes";
    }*/
    
    
}
