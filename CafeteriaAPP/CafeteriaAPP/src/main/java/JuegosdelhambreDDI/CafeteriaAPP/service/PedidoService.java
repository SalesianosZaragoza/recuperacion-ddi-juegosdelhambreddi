package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Pedido;
import JuegosdelhambreDDI.CafeteriaAPP.repository.PedidoRepository;


@Service
public class PedidoService {

    @Autowired

    PedidoRepository pedidoRepository;


    public List<Pedido> getAllPedidos() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(int id) {
        return pedidoRepository.findById(id);
    }

    public Pedido addPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(int id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> searchPedido(int userInput) {

        return pedidoRepository.findBynumPedido(userInput);
    }
    
}
