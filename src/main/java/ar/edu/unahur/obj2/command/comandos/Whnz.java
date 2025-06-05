package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Whnz implements Operable{
    private List<Operable> instrucciones = new ArrayList<>();

    public Whnz(List<Operable> instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        while(micro.getAcumuladorA() != 0){
            micro.run(instrucciones);
        }
    }

    @Override
    public void undo(Programable micro) {
        // ?????
    }

}
