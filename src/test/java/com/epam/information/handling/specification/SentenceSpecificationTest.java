package com.epam.information.handling.specification;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class SentenceSpecificationTest {
    private final Component FIRST_LEXEME = new Lexeme("name");
    private final Component SECOND_LEXEME = new Lexeme("my");

    @Test
    public void shouldReturnResultOfSizeComparing() {
        //given
        SentenceRegexsSpecification comparator = new SentenceRegexsSpecification("m");
        //when
        int result = comparator.compare(FIRST_LEXEME, SECOND_LEXEME);
        //then
        Assert.assertTrue(result < 0);
    }
}
