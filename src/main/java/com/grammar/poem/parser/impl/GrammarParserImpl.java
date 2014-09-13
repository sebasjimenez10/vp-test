package com.grammar.poem.parser.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;
import com.grammar.poem.parser.GrammarParser;

/**
 * Grammar Parser implementation.
 * @author sebastian
 *
 */
public class GrammarParserImpl implements GrammarParser {

	@Override
	public Grammar parseGrammar(String grammarFileName) throws IOException {
		
		// Let's read the file containing the grammar definition
		FileInputStream fis = new FileInputStream( grammarFileName );
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		// Let's initialize the grammar object
		Grammar grammar = new Grammar();
		
		// Rules identification and creation
		String line;
		while( (line = br.readLine()) != null ){
			
			// New rule
			Rule rule = new Rule();
			
			// 1. The first line is split by ':'
			String ruleAndValue[] = line.split(":");
			
			String ruleName = ruleAndValue[0].trim();
			String ruleValue = ruleAndValue[1].trim();
			
			rule.setName(ruleName);
			rule.setValue(ruleValue);
			
			// Set root rule name if not present yet
			setRootRuleName(grammar, ruleName);
			
			// 2. Get the evaluables lists. Elements that must be evaluated
			String[] evaluables = ruleValue.split(" ");
			
			List<List<String>> evals = new ArrayList<List<String>>();
			for (String evaluable : evaluables) {
				
				// List of possible options to each element that requires evaluation
				String[] options = evaluable.trim().split("\\|");
				List<String> opts = new ArrayList<String>();
				
				for (String option : options) {
					opts.add(option);
				}
				evals.add(opts);
			}
			
			// Setting evaluables to the rule
			rule.setEvaluables(evals);
			
			// Adding rule to the grammar
			grammar.getRules().put(ruleName, rule);
		}
		
		// Closing streams
		fis.close();
		br.close();
		
		return grammar;
	}

	/**
	 * Sets the name of the root rule if it's not set
	 * @param grammar
	 * @param ruleName
	 */
	private void setRootRuleName(Grammar grammar, String ruleName) {
		if (grammar.getRootRule() == null){
			grammar.setRootRule(ruleName);
		}
	}

	@Override
	public void printGrammar(String grammarFileName) throws IOException {
		
		// Let's read the file containing the grammar definition
		FileInputStream fis = new FileInputStream( grammarFileName );
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		// File reading
		String line;
		while( (line = br.readLine()) != null ){
			System.out.println( line );
		}
		
		// Closing streams
		fis.close();
		br.close();
	}
}
