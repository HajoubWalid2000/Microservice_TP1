package dcc.tp1.etudiant.service;

import dcc.tp1.etudiant.Modele.Filiere;
import dcc.tp1.etudiant.entities.Etudiant;
import dcc.tp1.etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EtudiantService {


    private EtudiantRepository etudiantRepository;

    private  RestTemplate restTemplate ;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
        this.restTemplate = new RestTemplate();
    }


    public Etudiant CreateEtudiant(Etudiant e){
        return  etudiantRepository.save(e);
    }

    public List<Etudiant> GetALLEtudiant(){
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        if (etudiantList != null){

            for (Etudiant e : etudiantList){
                Filiere f = restTemplate.getForObject("http://localhost:8081/v1/Filieres/"+e.getId_f(),Filiere.class);
                e.setFiliere(f);
            }
        }

        return etudiantList;
    }

    public Etudiant GetEtudiantByID(Long id){

        Etudiant etudiant =  etudiantRepository.findById(id).orElse(null);
        if(etudiant!= null){
            etudiant.setFiliere( restTemplate.getForObject("http://localhost:8081/v1/Filieres/"+ etudiant.getId_f(), Filiere.class) );
        }
        return  etudiant;
    }

    public Etudiant UpdateEtudiant(Long id, Etudiant e){
        return etudiantRepository.findById(id).map(etudiant -> {
            etudiant.setNom(e.getNom());
            etudiant.setPrenom(e.getPrenom());
            etudiant.setId_f(e.getId_f());
            return etudiantRepository.save(etudiant);
        }).orElseThrow(()-> new RuntimeException("pas existe"));
    }

    public void DeleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }




}
