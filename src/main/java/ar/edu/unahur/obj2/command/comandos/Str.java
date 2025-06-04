package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str implements Operable{

    @Override
    public void execute(Programable micro) {
        Integer valorA = micro.getAcumuladorA();
        micro.incProgramCounter();
        micro.setAddr(valorA);
    }

    @Override
    public void undo(Programable micro) {
        
    }

}
