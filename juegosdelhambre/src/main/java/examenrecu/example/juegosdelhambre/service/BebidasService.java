package examenrecu.example.juegosdelhambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examenrecu.example.juegosdelhambre.model.Bebida;
import examenrecu.example.juegosdelhambre.repository.ExampleRepository;

@Service
public class BebidasService {
    @Autowired
    ExampleRepository bebidas; 

    public String obtenerBebida() {
        // Aquí puedes agregar la lógica para obtener una bebida
        return "Coca-Cola";
    }
    
    public List<Bebida> getAllBebidas() {
        return bebidas.getAllBebidas();
    }

    public Bebida getBebidaById(int id) {
        return bebidas.getBebidaById(id);
    }

    public void addBebida(Bebida bebida) {
        bebidas.addBebida(bebida);
    }

    public void updateBebida(Bebida bebida) {
        bebidas.updateBebida(bebida);
    }

    public void deleteBebida(int id) {
        bebidas.deleteBebida(id);
    }

    public Bebida findBebidaById(int id) {
        return bebidas.findBebidaById(id);
    }

    public List<Bebida> searchBebida(String userInput) {
        List<Bebida> lista = bebidas.searchByNombre(userInput);
        for (Bebida bebida : lista) {
            System.out.println(bebida.getNombre() + " Precio: " + bebida.getPrecio());
        }
        return lista;
    }
}
