package com.epam.information.handling.chain.builder;

import com.epam.information.handling.parser.ParagraphParser;
import com.epam.information.handling.parser.Parser;
import com.epam.information.handling.parser.SentenceParser;
import com.epam.information.handling.parser.TextParser;

public class ChainBuilder {
    public Parser buildParserChain() {
        Parser parser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        parser.addSeccessor(paragraphParser)
                .addSeccessor(sentenceParser);
        return parser;
    }
}
