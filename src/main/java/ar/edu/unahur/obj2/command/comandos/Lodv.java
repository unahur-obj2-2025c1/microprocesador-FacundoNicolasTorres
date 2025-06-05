package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lodv implements Operable{
    private Integer val;
    private Integer anteriorA;

    public Lodv(Integer val){
        this.val = val;
    }

    @Override
    public void execute(Programable micro) {
        anteriorA = micro.getAcumuladorA();

        micro.incProgramCounter();
        micro.setAcumuladorA(val);
    }

    @Override
    public void undo(Programable micro) {
        micro.decProgramCounter();
        micro.setAcumuladorA(anteriorA);
    }

}
