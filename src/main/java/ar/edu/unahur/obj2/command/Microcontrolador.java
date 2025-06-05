package ar.edu.unahur.obj2.command;

import java.util.List;
import java.util.Stack;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Microcontrolador implements Programable{
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private Integer[] memoriaDeDatos = new Integer[1024];
    private Stack<Operable> lastInstructions = new Stack<>();
    
    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> {
            o.execute(this);
            lastInstructions.push(o);
        }
        );
    }

    public void undoLast(){
        lastInstructions.pop().undo(this);
    }
    
    @Override
    public void incProgramCounter() {
        programCounter++;
    }
    
    @Override
    public void decProgramCounter() {
        programCounter--;
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
        memoriaDeDatos[addr] = acumuladorA;
    }

    @Override
    public Integer getAddr(Integer addr) {
        return memoriaDeDatos[addr];
    }

}