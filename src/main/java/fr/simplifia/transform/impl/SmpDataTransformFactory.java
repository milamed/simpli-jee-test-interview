package fr.simplifia.transform.impl;

import fr.simplifia.input.validator.SmpInputValidator;
import fr.simplifia.transform.SmpDataTransformer;

import java.util.Locale;

public class SmpDataTransformFactory {

    public static SmpDataTransformer fromLocale(final SmpInputValidator validator, final Locale locale) {
        final SmpDataTransformer result;
        switch (locale.getLanguage()) {
            case ("en"):
                result = new SmpEnglishDataTransformer(validator);
                break;

            default:
                result = new SmpDefaultDataTransformer(validator);
                break;
        }
        return result;
    }
}
