package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.repository.CafeRepository;

@Service
public class CafeService {
   @Autowired
   CafeRepository cafes;

    public String obtenerCafe() {
        // Aquí puedes agregar la lógica para obtener un cafe
        return "Cafe";
    }

    public List<Cafe> getAllCafes() {
        return cafes.getAllCafes();
    }

    public Cafe getCafeById(int id) {
        return cafes.getCafeById(id);
    }

    public void addCafe(Cafe cafe) {
        cafes.addCafe(cafe);
    }

    public void updateCafe(Cafe cafe) {
        cafes.updateCafe(cafe);
    }

    public void deleteCafe(int id) {
        cafes.deleteCafe(id);
    }

    public List<Cafe> searchCafe(String userInput) {
        List<Cafe> lista = cafes.searchByNombre(userInput);
        for (Cafe cafe : lista) {
            System.out.println(cafe.getNomProducto() + " Precio: " + cafe.getPrecio());
        }
        return lista;
    }















}
