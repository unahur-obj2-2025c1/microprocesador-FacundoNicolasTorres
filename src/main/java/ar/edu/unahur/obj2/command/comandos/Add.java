package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Add implements Operable{
    private Integer anteriorA;
    private Integer anteriorB;

    @Override
    public void execute(Programable micro) {
        anteriorA = micro.getAcumuladorA();
        anteriorB = micro.getAcumuladorB();

        micro.incProgramCounter();
        micro.setAcumuladorA(
            micro.getAcumuladorA() + micro.getAcumuladorB()
        );
        micro.setAcumuladorB(0);
    }

    @Override
    public void undo(Programable micro) {
        micro.decProgramCounter();
        micro.setAcumuladorA(anteriorA);
        micro.setAcumuladorB(anteriorB);
    }

}
