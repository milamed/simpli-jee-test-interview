package fr.simplifia.transform;

import fr.simplifia.input.exception.InputException;
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

    public SmpDataTransformerTest() {
        validator = Mockito.mock(SmpInputValidator.class);
        doNothing().when(validator).validateInput(anyString());
    }

    @Test
    public void testTransformOk() throws Exception {
        SmpDataTransformer transformer = new SmpEnglishDataTransformer(validator);
        assertEquals(transformer.transform("test"), "test : Welcome to Simplifia!");
    }

    @Test(expectedExceptions = InputException.class)
    public void testTransformNotOk() throws Exception {
        SmpDataTransformer transformer = new SmpEnglishDataTransformer(validator);
        transformer.transform("ééé");

    }


    @Test
    public void testTransformEmpty() throws Exception {
        SmpDataTransformer transformer = new SmpEnglishDataTransformer(validator);
        assertEquals(transformer.transform(""), " : Welcome to Simplifia!");

    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testTransformNull() throws Exception {
        SmpDataTransformer transformer = new SmpEnglishDataTransformer(validator);
        transformer.transform(null);

    }


}