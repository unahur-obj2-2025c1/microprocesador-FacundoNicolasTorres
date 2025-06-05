package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Ifnz implements Operable{
    private List<Operable> instrucciones = new ArrayList<>();

    public Ifnz(List<Operable> instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        if(micro.getAcumuladorA() != 0){
            micro.run(instrucciones);
        }
    }

    @Override
    public void undo(Programable micro) {
        // ??????
    }
    
}
