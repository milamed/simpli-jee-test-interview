package fr.simplifia.output.impl;

import java.io.PrintStream;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by simplifia on 18/09/17.
 */
public class SmpOutputWriterImplTest {

    private PrintStream stream;

    public SmpOutputWriterImplTest(){
        stream = Mockito.mock(PrintStream.class);
       doNothing().when(stream).println(anyString());
    }


    @Test
    public void testPrint() throws Exception {
        SmpOutputWriterImpl outputStream = new SmpOutputWriterImpl(stream);
        String exmple =anyString();
        outputStream.print(exmple);
        Mockito.verify(stream).println(Mockito.eq(exmple));
        Mockito.reset(stream);
    }


    @Test
    public void testPrintEmpty() throws Exception {
        SmpOutputWriterImpl outputStream = new SmpOutputWriterImpl(stream);
        String exmple ="";
        outputStream.print(exmple);
        Mockito.verify(stream).println(Mockito.eq(exmple));
        Mockito.reset(stream);
    }


    @Test
    public void testPrintNull() throws Exception {
        SmpOutputWriterImpl outputStream = new SmpOutputWriterImpl(stream);
        String exmple =null;
        outputStream.print(exmple);
        Mockito.verify(stream).println(Mockito.eq(exmple));
        Mockito.reset(stream);
    }

}