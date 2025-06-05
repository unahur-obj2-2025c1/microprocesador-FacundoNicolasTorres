package ar.edu.unahur.obj2.command;

import java.util.HashMap;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Microcontrolador implements Programable{
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private Integer[] memoriaDeDatos = new Integer[1024];
    private HashMap<Character, Integer> lastInstruccions = new HashMap<>();
    
    public Microcontrolador(){
        lastInstruccions.put('a', acumuladorA);
        lastInstruccions.put('b', acumuladorB);
        lastInstruccions.put('c', programCounter);
    }
    
    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        lastInstruccions.put('c', programCounter);
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        lastInstruccions.put('a', acumuladorA);
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        lastInstruccions.put('b', acumuladorB);
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

    @Override
    public void undoAcumuladorA() {
        acumuladorA = lastInstruccions.get('a');
    }

    @Override
    public void undoAcumuladorB() {
        acumuladorB = lastInstruccions.get('b');
    }

    @Override
    public void undoProgramCounter() {
        programCounter = lastInstruccions.get('c');
    }
    

}