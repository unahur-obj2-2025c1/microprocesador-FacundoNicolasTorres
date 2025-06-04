package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Swap implements Operable{

    @Override
    public void execute(Programable micro) {
        Integer valorA = micro.getAcumuladorA();
        Integer valorB = micro.getAcumuladorB();
        
        micro.incProgramCounter();
        micro.setAcumuladorA(valorB);
        micro.setAcumuladorB(valorA);
    }

    @Override
    public void undo(Programable micro) {
       //...
    }

}
