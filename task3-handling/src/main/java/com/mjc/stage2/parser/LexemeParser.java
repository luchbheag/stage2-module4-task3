package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType() == TextComponentType.SENTENCE) {
            String[] lexemes = string.split(LEXEME_REGEX);
            AbstractTextComponent newTextComponent;
            for (String lexeme : lexemes) {
                if (lexeme.matches(WORD_REGEX)) {
                    newTextComponent = new TextComponent(TextComponentType.WORD);
                    if (nextParser != null) {
                        nextParser.parse(newTextComponent, lexeme);
                    }
                } else {
                    newTextComponent = new SymbolLeaf(TextComponentType.SYMBOL, lexeme.charAt(0));
                }
            }
        } else if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }
}
