package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lod implements Operable{
    Integer addr;

    public Lod(Integer addr){
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        Integer valorAddr = micro.getAddr(addr);
        micro.incProgramCounter();
        micro.setAcumuladorA(valorAddr);
    }

    @Override
    public void undo(Programable micro) {
       
    }

}
