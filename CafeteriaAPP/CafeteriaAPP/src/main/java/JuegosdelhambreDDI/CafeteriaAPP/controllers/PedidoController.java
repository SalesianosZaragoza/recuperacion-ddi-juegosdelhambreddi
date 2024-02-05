package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Consumicion;
import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;
import JuegosdelhambreDDI.CafeteriaAPP.model.Trabajador;
import JuegosdelhambreDDI.CafeteriaAPP.model.Usuario;
import JuegosdelhambreDDI.CafeteriaAPP.service.ConsumicionService;
import JuegosdelhambreDDI.CafeteriaAPP.service.PedidoService;
import JuegosdelhambreDDI.CafeteriaAPP.service.TrabajadorService;
import JuegosdelhambreDDI.CafeteriaAPP.service.UsuarioService;


@Controller
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private TrabajadorService trabajadorService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ConsumicionService consumicionService;
        
            
    @RequestMapping("/insertPedido")
    public String insertPedidoForm(Model model) {
        List<Trabajador> trabajadores = trabajadorService.getAllTrabajador();
        Iterable<Usuario> usuarios = usuarioService.getAllUsuario();
        Iterable<Consumicion> consumiciones = consumicionService.getAllConsumiciones();
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("consumiciones", consumiciones);
        model.addAttribute("pedidoNuevo", new Pedido());
        return "pedido/pedidoForm";
    }


    @RequestMapping("/crearPedido")
    public String crearPedido(Pedido pedidoNuevo, Model model) {
        // pedidoNuevo.setNumPedido(pedidoNuevo.getConsumicion());
        Pedido pedido = pedidoService.addPedido(pedidoNuevo);
        return this.listarPedido(model);
    }

    // @RequestMapping("/crearPedidoNuevo")
    // public String crearPedidoNuevo(Pedido pedidoNuevo, Model model) {
    //     // System.out.println("crearpedidoNuevo");
    //     Pedido Pedido = pedidoService.addPedido(pedidoNuevo);
    //     Iterable<Pedido> lista = pedidoService.getAllPedidos();
    //     model.addAttribute("pedidos", lista);
    //     return "pedido/listarPedido";
    // }

    @RequestMapping("/listarPedido")
    public String listarPedido(Model model) {
        Iterable<Pedido> lista = pedidoService.getAllPedidos();
        model.addAttribute("pedidos", lista);
        

        return "pedido/listarPedido";
    }
}
