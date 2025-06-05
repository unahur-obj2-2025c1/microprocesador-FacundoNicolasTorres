package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str implements Operable{
    private Integer addr;

    public Str(Integer addr){
        this.addr = addr;
    }

    public Integer getAddr() {
        return addr;
    }

    @Override
    public void execute(Programable micro) {
        micro.incProgramCounter();
        micro.setAddr(addr);
    }

    @Override
    public void undo(Programable micro) {
        micro.undoProgramCounter();
    }

}
