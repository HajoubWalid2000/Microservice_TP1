package dcc.tp1.etudiant.controller;

import dcc.tp1.etudiant.Modele.Filiere;
import dcc.tp1.etudiant.entities.Etudiant;
import dcc.tp1.etudiant.service.EtudiantService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1/Etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;



    @PostMapping
    public ResponseEntity<Etudiant> add(@RequestBody Etudiant e){
        Etudiant etudiant = etudiantService.CreateEtudiant(e);
        return ResponseEntity.ok(etudiant);
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAll(){
        List<Etudiant> etudiantList = etudiantService.GetALLEtudiant();

        return ResponseEntity.ok(etudiantList);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getbyid(@PathVariable Long id){
        Etudiant etudiant =  etudiantService.GetEtudiantByID(id);
        return ResponseEntity.ok(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> Update(@PathVariable Long id,@RequestBody Etudiant etudiant){
        Etudiant e = etudiantService.UpdateEtudiant(id,etudiant);
        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        etudiantService.DeleteEtudiant(id);
        return ResponseEntity.ok().build();
    }






}
