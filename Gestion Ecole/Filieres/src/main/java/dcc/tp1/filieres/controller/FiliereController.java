package dcc.tp1.filieres.controller;

import dcc.tp1.filieres.entities.Filiere;
import dcc.tp1.filieres.service.FilireService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/Filieres")
@OpenAPIDefinition(
        info = @Info(
                title = "La Gestion des filiere",
                description = "offre les opération pour gérer les filiere",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8081/"
        )
)

public class FiliereController {

    @Autowired
    private FilireService filireService;


    @Operation(
            summary = "ajouter nouvel filiere",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Filiere.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode ="200",description = "Bien Ajouter",
                                content = @Content(mediaType = "applaction/json"
                                        ,schema = @Schema(implementation = Filiere.class))),
                    @ApiResponse(responseCode = "400",description = "mal ajouter")
            }



    )
    @PostMapping
    public ResponseEntity<Filiere> add(@RequestBody Filiere F){
        Filiere filiere = filireService.CreateFiliere(F);
        return ResponseEntity.ok(filiere);
    }

    @GetMapping
    public ResponseEntity<List<Filiere>> GetALL(){
        List<Filiere> filieres = filireService.GetAllFiliere();
        return ResponseEntity.ok(filieres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getbyId(@PathVariable Long id){
        Filiere filiere = filireService.GetAllFiliereById(id);
        return ResponseEntity.ok(filiere);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filiere> update(@PathVariable Long id, @RequestBody Filiere f){
        Filiere filiere = filireService.UpdateFiliere(id,f);
        return ResponseEntity.ok(filiere);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity Delete(@PathVariable Long id){
        filireService.DeleteFiliere(id);
        return ResponseEntity.ok().build();
    }






}
