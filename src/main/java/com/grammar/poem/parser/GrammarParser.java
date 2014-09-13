package com.grammar.poem.parser;

import java.io.IOException;

import com.grammar.poem.model.Grammar;

/**
 * 
 * @author sebastian
 *
 */
public interface GrammarParser {

	/**
	 * Parse a grammar given the grammar definition
	 * @return Grammar
	 */
	Grammar parseGrammar( String grammarFileName ) throws IOException;

	/**
	 * Prints out to the console the grammar
	 * @param grammarFileName
	 * @throws IOException
	 */
	void printGrammar( String grammarFileName ) throws IOException;
}
