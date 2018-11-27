package com.epam.information.handling.chain.builder;

import com.epam.information.handling.parser.ParagraphParser;
import com.epam.information.handling.parser.Parser;
import com.epam.information.handling.parser.SentenceParser;
import com.epam.information.handling.parser.TextParser;
import org.junit.Assert;
import org.junit.Test;

public class ChainBuilderTest {
    @Test
    public void shouldCreateParserChain() {
        //given
        ChainBuilder builder = new ChainBuilder();

        //when
        Parser parserChain = builder.buildParserChain();

        //then
        Assert.assertEquals(parserChain.getClass(), TextParser.class);
        Parser paragraphParser = parserChain.getSuccessor();
        Assert.assertEquals(paragraphParser.getClass(), ParagraphParser.class);
        Parser sentenceParser = paragraphParser.getSuccessor();
        Assert.assertEquals(sentenceParser.getClass(), SentenceParser.class);
    }
}
