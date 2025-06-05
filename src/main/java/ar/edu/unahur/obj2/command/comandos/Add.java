package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Add implements Operable{

    @Override
    public void execute(Programable micro) {
        micro.incProgramCounter();
        micro.setAcumuladorA(
            micro.getAcumuladorA() + micro.getAcumuladorB()
        );
        micro.setAcumuladorB(0);
    }

    @Override
    public void undo(Programable micro) {
        micro.undoProgramCounter();
        micro.undoAcumuladorA();
        micro.undoAcumuladorB();
    }

}
