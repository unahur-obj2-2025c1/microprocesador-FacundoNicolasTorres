package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Add;
import ar.edu.unahur.obj2.command.comandos.Lod;
import ar.edu.unahur.obj2.command.comandos.Lodv;
import ar.edu.unahur.obj2.command.comandos.Nop;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.Str;
import ar.edu.unahur.obj2.command.comandos.Swap;

public class ProgramBuilder {
    private List<Operable> programa = new ArrayList<>();

    public List<Operable> getPrograma(){
        return programa;
    }

    public void reset(){
        programa = new ArrayList<>();
    }

    public void nop(){
        programa.add(new Nop());
    }

    public void add(){
        programa.add(new Add());
    }

    public void lod(Integer addr){
        programa.add(new Lod(addr));
    }

    public void lodv(Integer val){
        programa.add(new Lodv(val));
    }

    public void str(){
        programa.add(new Str());
    }

    public void swap(){
        programa.add(new Swap());
    }
}
