package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;
import JuegosdelhambreDDI.CafeteriaAPP.service.PedidoService;


@Controller
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
        
            
    @RequestMapping("/insertPedido")
    public String insertPedidoForm(Model model) {

        model.addAttribute("pedidoNuevo", new Pedido());
        return "pedido/pedidoForm";
    }


    @RequestMapping("/crearPedido")
    public String crearPedido(Pedido pedidoNuevo, Model model) {
        pedidoNuevo.setNumPedido(pedidoNuevo.getConsumicion().getId());
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
