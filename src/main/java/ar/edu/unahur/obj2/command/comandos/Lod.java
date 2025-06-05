package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lod implements Operable{
    private Integer addr;
    private Integer anteriorA;

    public Lod(Integer addr){
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        anteriorA = micro.getAcumuladorA();

        Integer valorAddr = micro.getAddr(addr);
        micro.incProgramCounter();
        micro.setAcumuladorA(valorAddr);
    }

    @Override
    public void undo(Programable micro) {
        micro.decProgramCounter();
        micro.setAcumuladorA(anteriorA);
    }

}
