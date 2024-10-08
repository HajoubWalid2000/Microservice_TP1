package dcc.tp1.filieres.service;

import dcc.tp1.filieres.Repository.FiliereRepository;
import dcc.tp1.filieres.entities.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilireService {

    @Autowired
    FiliereRepository filiereRepository;

    public Filiere CreateFiliere( Filiere f){
        return filiereRepository.save(f);
    }

    public List<Filiere> GetAllFiliere(){
        return filiereRepository.findAll();
    }

    public Filiere GetAllFiliereById(Long id){
        return filiereRepository.findById(id).orElse(null);
    }

    public Filiere UpdateFiliere(Long id, Filiere f){
        return filiereRepository.findById(id).map(filiere ->{
                    filiere.setCode(f.getCode());
                    filiere.setLibelle(f.getLibelle());
                    return  filiereRepository.save(filiere);
            }).orElseThrow(() -> new RuntimeException("non trouvé"));
    }

    public void DeleteFiliere(Long id){
        filiereRepository.deleteById(id);
    }


}
