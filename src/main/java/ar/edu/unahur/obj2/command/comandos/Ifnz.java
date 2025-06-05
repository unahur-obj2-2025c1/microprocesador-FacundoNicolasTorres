package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Ifnz implements Operable{
    private List<Operable> instrucciones = new ArrayList<>();
    private Boolean seEjecuto = Boolean.FALSE;

    public Ifnz(List<Operable> instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        micro.incProgramCounter();
        if(micro.getAcumuladorA() != 0){
            seEjecuto = Boolean.TRUE;
            instrucciones.forEach(o -> o.execute(micro));
        }
    }

    @Override
    public void undo(Programable micro) {
        micro.decProgramCounter();
        if(seEjecuto){
            List<Operable> listaInvertida = new ArrayList<>(instrucciones);
            Collections.reverse(listaInvertida);
            listaInvertida.forEach(ins -> ins.undo(micro));
        }
    }
    
}
