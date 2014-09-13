package com.grammar.poem.parser;

import com.grammar.poem.model.Grammar;

public interface GrammarParser {

	Grammar parseGrammar(String grammarFile);
	
}
