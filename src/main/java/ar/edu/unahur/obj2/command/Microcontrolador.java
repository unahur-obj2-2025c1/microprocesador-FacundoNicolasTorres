package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microcontrolador implements Programable{
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoriaDeDatos = new ArrayList<>();

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void copyFrom(Programable programable) {

    }

    @Override
    public Programable copy() {
        return this;
        //No se
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
    }

    @Override
    public void setAddr(Integer addr) {
        if(memoriaDeDatos.size() > 1023){
            new MicroException("Fuera del espacio de memoria");
        }
        memoriaDeDatos.add(addr);
    }

    @Override
    public Integer getAddr(Integer addr) {
        if(!(addr >= 0 || addr <= 1023)){
            new MicroException("Fuera del espacio de memoria");
        }
        return memoriaDeDatos.get(addr);
    }

}