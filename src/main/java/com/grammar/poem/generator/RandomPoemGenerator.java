package com.grammar.poem.generator;

import java.util.List;
import java.util.Random;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Grammar.Keywords;
import com.grammar.poem.model.Rule;

public class RandomPoemGenerator {

	public static void generatePoem(Grammar grammar) {
		
		Rule rootRule = grammar.getRules().get(grammar.getRootRule());
		
		printKeywordOrWord(rootRule, grammar);
	}
	
	private static void printKeywordOrWord(Rule rule, Grammar grammar) {
		
		List<List<String>> evaluables = rule.getEvaluables();
		
		for (List<String> options : evaluables) {
			
			// Get a random option
			int random = randomNumber(0, options.size());
			String opt = options.get( random );
			
			// Let's see if the option is:
			// 1. word
			// 2. rule
			// 3. keyword
			
			if( opt.matches("<[A-Z]+>") ){
				// It's a rule
				// Call the method to get a keyword or a word
				Rule subRule = grammar.getRules().get(opt.substring(1, opt.length() - 1));
				printKeywordOrWord(subRule, grammar);
				
			}else if( opt.matches("\\$[A-Z]+") ){
				// Is a keyword
				Keywords valueOf = Grammar.Keywords.valueOf(opt);
				System.out.print( valueOf.getValue() );
				
			}else{
				// Is a word
				// Print it
				System.out.print( opt );
				System.out.print(" ");
			}
		}
	}

	private static int randomNumber(int min, int max){
		Random r = new Random();
		int random = r.nextInt(max - min) + min;
		
		return random;
	}

}
