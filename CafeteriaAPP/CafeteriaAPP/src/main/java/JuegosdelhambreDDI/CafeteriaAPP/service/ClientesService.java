package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cliente;
import JuegosdelhambreDDI.CafeteriaAPP.repository.ClienteRepository;

@Service
public class ClientesService {
    @Autowired
    ClienteRepository clienteRepository;

    public String obtenerCliente() {
        return "Cliente";
    }

    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    public Cliente addCliente(Cliente cliente) {
         return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> searchCliente(String userInput) {

        return clienteRepository.findBynomCliente(userInput);
    }




}
