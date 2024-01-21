package JuegosdelhambreDDI.CafeteriaAPP.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Consumicion;
import JuegosdelhambreDDI.CafeteriaAPP.repository.ConsumicionRepository;

@Service
public class ConsumicionService {
    
    @Autowired
    ConsumicionRepository consumicionRepository;


    public List<Consumicion> getAllConsumiciones() {
        return (List<Consumicion>) consumicionRepository.findAll();
    }

    public Optional<Consumicion> getConsumicionById(int id) {
        return consumicionRepository.findById(id);
    }

    public Consumicion addConsumicion(Consumicion consumicion) {
        return consumicionRepository.save(consumicion);
    }

    public void deleteConsumicion(int id) {
        consumicionRepository.deleteById(id);
    }

    public List<Consumicion> searchConsumicion(String userInput) {

        return consumicionRepository.findBynomProducto(userInput);
    }
    



}
