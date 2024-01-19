package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.repository.CafeRepository;

@Service
public class CafeService {
    @Autowired
    CafeRepository cafeRepository;

    // private final CafeRepository cafeRepository;
    // @Autowired
    // public CafeService(CafeRepository cafeRepository) {
    //     this.cafeRepository = cafeRepository;
    // }

    public String obtenerCafe() {
        // Aquí puedes agregar la lógica para obtener un cafe
        return "Cafe";
    }

    public Iterable<Cafe> getAllCafes() {
        return cafeRepository.findAll();
    }

    public Optional<Cafe> getCafeById(int id) {
        return cafeRepository.findById(id);
    }


    public Cafe addCafe(Cafe cafe) {
        return cafeRepository.save(cafe);

    }

    public Cafe updateCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
    }

    public void deleteCafe(int id) {
        cafeRepository.deleteById(id);
    }

    public List<Cafe> searchCafe(String userInput) {

        return cafeRepository.findBynomProducto(userInput);
    }















}
