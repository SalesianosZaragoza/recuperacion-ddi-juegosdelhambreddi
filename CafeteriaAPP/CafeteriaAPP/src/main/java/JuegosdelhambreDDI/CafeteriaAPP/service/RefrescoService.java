package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Refresco;
import JuegosdelhambreDDI.CafeteriaAPP.repository.RefrescoRepository;



@Service
public class RefrescoService {

    @Autowired

    RefrescoRepository refrescoRepository;


    public List<Refresco> getAllRefrescos() {
        return (List<Refresco>) refrescoRepository.findAll();
    }

    public Optional<Refresco> getRefrescoById(int id) {
        return refrescoRepository.findById(id);
    }

    public Refresco addRefresco(Refresco refresco) {
        return refrescoRepository.save(refresco);
    }

    public void deleteRefresco(int id) {
        refrescoRepository.deleteById(id);
    }
    
    public List<Refresco> searchRefresco(String userInput) {
    
        return refrescoRepository.findBynomProducto(userInput); 
    }

    
}
