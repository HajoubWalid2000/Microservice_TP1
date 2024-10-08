package dcc.tp1.tp_ex1.controller;


import dcc.tp1.tp_ex1.entities.Nombres;
import dcc.tp1.tp_ex1.service.ServiceCalcule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/calculs")
public class CalculAPI {

    @Autowired
    ServiceCalcule serviceCalcule;

    @GetMapping
    public ResponseEntity<Map<String,Double>> calulsomme(@RequestParam double a, @RequestParam double b){

        Nombres nombres = new Nombres(a,b);
        double som = serviceCalcule.SommeOperation(nombres);
        Map<String,Double> reponsejson = new HashMap<>();
        reponsejson.put("somme",som);

        return ResponseEntity.ok(reponsejson);

    }



}
