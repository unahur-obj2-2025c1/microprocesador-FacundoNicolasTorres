package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MicroprocesadorTest {
    private Programable micro = new Microcontrolador();
    private ProgramBuilder programa = new ProgramBuilder(micro);
    
    @BeforeEach
    void setUp(){
        micro.reset();
        programa.reset();
    }
    
    
    @Test
    void elProgramaHaceNOP_YElProgramCounterSeIncrementa(){
        programa.nop();
        programa.nop();
        programa.nop();

        programa.run();

        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    void programaQueSumaDosNumeros_SeIncrementaElProgramCounterYCambianLosAcumuladores(){
        programa.lodv(20);
        programa.swap();
        programa.lodv(17);
        programa.add();

        programa.run();

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    void programaQueSumaTresNumeros_GuardandoUnDatoEnLaMemoriaDeDatosYSumandoCorrectamente(){
        programa.lodv(2);
        programa.str(0);
        programa.lodv(8);
        programa.swap();
        programa.lodv(5);
        programa.add();
        programa.swap();
        programa.lod(0);
        programa.add();

        programa.run();

        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(9, micro.getProgramCounter());
    }

    @Test
    void programaConLaInstruccionIfnzSeLeHaceUndoYVuelveAlValoranteriorDelPrograma(){
        ProgramBuilder prog2 = new ProgramBuilder(micro);

        programa.lodv(2);
        
        prog2.str(0);
        prog2.lodv(8);
        prog2.swap();
        prog2.nop();
        prog2.lodv(5);
        prog2.add();
        prog2.swap();
        prog2.lod(0);
        prog2.add();

        programa.ifnz(prog2.getPrograma());

        programa.run();
        programa.undoLast();

        assertEquals(2, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(1, micro.getProgramCounter());
    }

    @Test
    void programaConInstruccionWhnz_SeHaceUndoYVuelveAlEstadoAnteriorDelPrograma(){
        ProgramBuilder prog2 = new ProgramBuilder(micro);

        programa.lodv(2);

        prog2.str(0);
        prog2.lodv(8);
        prog2.swap();
        prog2.nop();
        prog2.lodv(5);
        prog2.add();
        prog2.str(1);
        prog2.lodv(0);

        programa.whnz(prog2.getPrograma());

        programa.run();
        programa.undoLast();

        assertEquals(2, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(1, micro.getProgramCounter());
    }

    @Test
    void programaConIfnzEmpiezaConElAcumuladorAEn0_YNoHaceNada(){
        ProgramBuilder prog2 = new ProgramBuilder(micro);

        prog2.lodv(2);
        prog2.str(0);
        prog2.lodv(8);
        prog2.swap();
        prog2.nop();
        prog2.lodv(5);
        prog2.add();
        prog2.swap();
        prog2.lod(0);
        prog2.add();

        programa.ifnz(prog2.getPrograma());

        programa.run();
        programa.undoLast();

        assertEquals(0, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(0, micro.getProgramCounter());
    }

}
