package dcc.tp1.tp_ex1.service;

import dcc.tp1.tp_ex1.entities.Nombres;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalcule {

    public double SommeOperation(Nombres nombres){
        return nombres.getA()+nombres.getB();
    }



}
