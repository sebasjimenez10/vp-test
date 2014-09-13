package com.grammar.poem;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.grammar.poem.generator.RandomPoemGenerator;
import com.grammar.poem.model.Grammar;
import com.grammar.poem.parser.GrammarParser;
import com.grammar.poem.parser.impl.GrammarParserImpl;

public class Main {

	private static final String PRINT_GRAMMAR_OPT = "-g";
	private static final String FILE_OPT = "-f:";
	private static final String DEFAULT_FILE_NAME = "poem.grammar";
	
	public static void main(String args []) {
		
		// Initializing grammar parser
		GrammarParser gp = new GrammarParserImpl();
		String grammarFileName = DEFAULT_FILE_NAME;
		
		// Options reading
		// Getting file if provided
		List<String> opts = Arrays.asList(args);
		for (String opt : opts) {
			if( opt.contains(FILE_OPT) ){
				grammarFileName = opt.substring( opt.indexOf(":") + 1 );
			}
		}
		// Printing grammar if required
		if( opts.contains(PRINT_GRAMMAR_OPT) ){
			try {
				gp.printGrammar(grammarFileName);
				System.out.println();
			} catch (Exception e) {
				Logger.getLogger( Main.class.getName() ).log(Level.SEVERE, e.getMessage());
				System.exit(-1);
			}
		}
		
		// 1. Parse Grammar
		Grammar grammar = null;
		try {
			grammar = gp.parseGrammar(grammarFileName);
		} catch (Exception e) {
			Logger.getLogger( Main.class.getName() ).log(Level.SEVERE, e.getMessage());
			System.exit(-1);
		}
		
		// 2. Generate random poem
		RandomPoemGenerator.generatePoem(grammar);
	}
	
}
