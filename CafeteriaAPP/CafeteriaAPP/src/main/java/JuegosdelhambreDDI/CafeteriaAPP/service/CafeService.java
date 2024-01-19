package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.repository.CafeRepository;

@Service
public class CafeService {
   @Autowired
   CafeRepository cafeRepository;

    public String obtenerCafe() {
        // Aquí puedes agregar la lógica para obtener un cafe
        return "Cafe";
    }

    public List<Cafe> getAllCafes() {
        return  StreamSupport.stream(cafeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    }

    public Optional<Cafe> getCafeById(int id) {
        return cafeRepository.findById(id);
    }


    public Cafe addCafe(Cafe cafe) {
        return cafeRepository.save(cafe);

		// return cafeRepository.findById(cafe.getId());
	
    }

    public Cafe updateCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
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
