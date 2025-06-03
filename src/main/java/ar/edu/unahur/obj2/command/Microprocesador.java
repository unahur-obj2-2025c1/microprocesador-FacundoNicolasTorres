package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Microprocesador implements Programable{
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;

    public Microprocesador(Integer acumuladorA, Integer acumuladorB, Integer programCounter){
        this.acumuladorA = acumuladorA;
        this.acumuladorB = acumuladorB;
        this.programCounter = programCounter;
    }

    @Override
    public void run(List<Operable> operaciones) {

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

    }

    @Override
    public void reset() {

    }

    @Override
    public void setAddr(Integer addr) {

    }

    @Override
    public Integer getAddr(Integer addr) {

    }

}