package fr.simplifia.transform;

import fr.simplifia.input.validator.SmpInputValidator;
import fr.simplifia.transform.impl.SmpDataTransformFactory;
import fr.simplifia.transform.impl.SmpEnglishDataTransformer;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Locale;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;


public class SmpDataTransformerTest {

    private SmpInputValidator validator;

    public SmpDataTransformerTest(){
        validator = Mockito.mock(SmpInputValidator.class);
        //TODO : mocking strategy
        doNothing().when(validator).validateInput(anyString());
    }

    @Test
    public void testTransformOk() throws Exception {
        SmpDataTransformer transformer = SmpDataTransformFactory.fromLocale(validator, Locale.ENGLISH);
        Mockito.verify(transformer).transform("test").equals("test"+" : Welcome to Simplifia!");
        Mockito.reset(transformer);


    }

    @Test
    public void testTransformNotOk() throws Exception {

    }


    @Test
    public void testTransformEmpty() throws Exception {

    }

    @Test
    public void testTransformNull() throws Exception {

    }


}