package br.jus.trf1.trf1sisprecapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
