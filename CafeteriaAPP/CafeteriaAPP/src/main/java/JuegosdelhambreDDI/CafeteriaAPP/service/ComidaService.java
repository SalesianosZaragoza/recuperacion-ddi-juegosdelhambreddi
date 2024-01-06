package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Comida;
import JuegosdelhambreDDI.CafeteriaAPP.repository.ComidaRepository;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    public List<Comida> getAllComidas() {
        return comidaRepository.getAllComidas();
    }

    public Comida getComidaById(Long id) {
        return comidaRepository.getComidaById(id);
    }

    public Comida saveComida(Comida comida) {
        return comidaRepository.updateComida(comida);
    }

    public void deleteComida(Long id) {
        comidaRepository.deleteComida(id);
    }
}