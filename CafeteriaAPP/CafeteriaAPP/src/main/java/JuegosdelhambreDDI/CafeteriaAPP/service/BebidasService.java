package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Bebida;
import JuegosdelhambreDDI.CafeteriaAPP.repository.BebidaRepository;

@Service
public class BebidasService {
    @Autowired
    BebidaRepository bebidaRepository; 

    public String obtenerBebida() {
        // Aquí puedes agregar la lógica para obtener una bebida
        return "Coca-Cola";
    }
    
    public Iterable<Bebida> getAllBebidas() {
        return bebidaRepository.findAll();
    }

    public Optional<Bebida> getBebidaById(int id) {
        return bebidaRepository.findById(id);
    }

    public Bebida addBebida(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    public Bebida updateBebida(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    public void deleteBebida(int id) {
        bebidaRepository.deleteById(id);
    }

    public List<Bebida> searchBebidaByCafe(String userInput) {
        return bebidaRepository.findBycafe(userInput);
    }

    public List<Bebida> searchBebidaByRefersco(String userInput) {
        return bebidaRepository.findByrefresco(userInput);
    }
}
