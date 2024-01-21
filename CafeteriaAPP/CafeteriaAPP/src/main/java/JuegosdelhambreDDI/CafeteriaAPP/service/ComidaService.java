package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.repository.ComidaRepository;

@Service
public class ComidaService {

    @Autowired
    ComidaRepository comidaRepository;

    public Iterable<Comida> getAllComidas() {
        return comidaRepository.findAll();
    }

    public Optional<Comida> getComidaById(int id) {
        return comidaRepository.findById(id);
    }

    public void deleteComida(int id) {
        comidaRepository.deleteById(id);
    }
}