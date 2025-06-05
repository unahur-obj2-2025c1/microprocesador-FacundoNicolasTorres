package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Whnz implements Operable{
    private List<Operable> instrucciones = new ArrayList<>();
    private Integer vecesEjecutada = 0;

    public Whnz(List<Operable> instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        while(micro.getAcumuladorA() != 0){
            vecesEjecutada++;
            instrucciones.forEach(o -> o.execute(micro));
        }
    }

    @Override
    public void undo(Programable micro) {
        micro.decProgramCounter();
        while(vecesEjecutada != 0){
            vecesEjecutada--;
            List<Operable> listaInvertida = new ArrayList<>(instrucciones);
            Collections.reverse(listaInvertida);
            listaInvertida.forEach(ins -> ins.undo(micro));
        }
    }

}
