package JuegosdelhambreDDI.CafeteriaAPP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegosdelhambreDDI.CafeteriaAPP.model.Trabajador;
import JuegosdelhambreDDI.CafeteriaAPP.repository.TrabajadorRepository;


@Service
public class TrabajadorService {

    @Autowired

    TrabajadorRepository trabajadores;
    
    
}
