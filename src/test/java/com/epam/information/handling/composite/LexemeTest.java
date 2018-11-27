package com.epam.information.handling.composite;

import org.junit.Assert;
import org.junit.Test;

public class LexemeTest {
    @Test
    public void shouldReturnNumberOfInclusion() {
        //given
        Lexeme lexeme = new Lexeme("ADS asd ASD");
        //when
        int inclusionNumber = lexeme.getInclusionNumber("A");
        //then
        Assert.assertEquals(inclusionNumber, 2);
    }

    @Test
    public void shouldCreateSameLexeme() {
        //given
        Lexeme lexeme = new Lexeme("Sadsad");
        //when
        Lexeme newLexeme = new Lexeme(lexeme);
        //then
        Assert.assertEquals(lexeme, newLexeme);
    }
}
