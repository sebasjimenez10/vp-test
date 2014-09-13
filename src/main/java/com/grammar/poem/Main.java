package com.grammar.poem;

import java.util.Map;
import com.grammar.poem.generator.RandomPoemGenerator;
import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;
import com.grammar.poem.parser.GrammarParser;
import com.grammar.poem.parser.impl.GrammarParserImpl;

public class Main {

	public static void main(String args []){
		System.out.println("======= Starting poem generator =======");
		// 1. Parse Grammar
		GrammarParser gp = new GrammarParserImpl();
		Grammar grammar = gp.parseGrammar("poem.grammar");
		
		System.out.println("- Rules identified:\n");
		Map<String, Rule> rules = grammar.getRules();
		
		for (String ruleName : rules.keySet()) {
			System.out.println(ruleName);
		}
		
		
		// 2. Generate random poem
		System.out.println("\n");
		RandomPoemGenerator.generatePoem(grammar);
		
		System.out.println("\n======= Finishing poem generator =======");
	}
	
}
