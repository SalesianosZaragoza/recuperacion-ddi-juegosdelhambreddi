package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Trabajador;
import JuegosdelhambreDDI.CafeteriaAPP.repository.TrabajadorRepository;


@Service
public class TrabajadorService {

    @Autowired
    TrabajadorRepository trabajadoresRepository;
    
    public List<Trabajador> getAllTrabajador() {
        return (List<Trabajador>) trabajadoresRepository.findAll();
    }

    public Optional<Trabajador> getTrabajadorById(int id) {
        return trabajadoresRepository.findById(id);
    }

    public Trabajador addTrabajador(Trabajador trabajador) {
        return trabajadoresRepository.save(trabajador);
    }

    public void deleteTrabajador(int id) {
        trabajadoresRepository.deleteById(id);
    }

    public List<Trabajador> searchTrabajador(String userInput) {
        return trabajadoresRepository.findByNomTrabajador(userInput);
    }

    public Trabajador searchTrabajadorbyEmail(String userInput) {
        return trabajadoresRepository.findByEmail(userInput);
    }
}
