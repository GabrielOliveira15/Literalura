package com.api.Literalura.models;

public enum Idiomas {
    en("Inglês"),
    fr("Francês"),
    pt("Português"),
    fi("Finlandês");

    private String idioma;

    Idiomas(String idioma) {
        this.idioma = idioma;
    }

    public static Idiomas fromString(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.idioma.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Idioma não encontrada: " + text);
    }
}
