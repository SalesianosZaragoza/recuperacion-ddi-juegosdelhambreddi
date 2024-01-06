package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cliente;
import JuegosdelhambreDDI.CafeteriaAPP.repository.ClienteRepository;

@Service
public class ClientesService {
    @Autowired
    ClienteRepository clientes;

    public String obtenerCliente() {
        return "Cliente";
    }

    public List<Cliente> getAllClientes() {
        return clientes.getAllClientes();
    }

    public Cliente getClienteById(int id) {
        return clientes.getClienteById(id);
    }

    public void addCliente(Cliente cliente) {
        clientes.addCliente(cliente);
    }

    public void updateCliente(Cliente cliente) {
        clientes.updateCliente(cliente);
    }

    public void deleteCliente(int id) {
        clientes.deleteCliente(id);
    }

    public List<Cliente> searchCliente(String userInput) {
        List<Cliente> lista = clientes.searchByNombre(userInput);
        for (Cliente cliente : lista) {
            System.out.println(cliente.getNombre() + " Precio: " + cliente.getApellido());
        }
        return lista;
    }




}
