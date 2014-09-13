package com.grammar.poem.parser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;
import com.grammar.poem.parser.GrammarParser;

public class GrammarParserImpl implements GrammarParser {

	public Grammar parseGrammar(String grammarFile) {
		
		Grammar grammar = new Grammar();
		
		try {
			
			InputStream stream = this.getClass().getClassLoader().getResourceAsStream(grammarFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
		
			String line = br.readLine();
			
			// Rule identification and creation
			while( line != null ){
				
				Rule rule = new Rule();
				
				// 1. The first line is split by ':'
				String ruleAndValue[] = line.split(":");
				
				String ruleName = ruleAndValue[0].trim();
				String ruleValue = ruleAndValue[1].trim();
				
				rule.setName(ruleName);
				rule.setValue(ruleValue);
				
				// Set root rule name if not present yet
				setRootRuleName(grammar, ruleName);
				
				// 2. Get the evaluables lists
				String[] evaluables = ruleValue.split(" ");
				
				List<List<String>> evals = new ArrayList<List<String>>();
				for (String evaluable : evaluables) {
					
					String[] options = evaluable.trim().split("\\|");
					List<String> opts = new ArrayList<String>();
					
					for (String option : options) {
						opts.add(option);
					}
					evals.add(opts);
				}
				
				rule.setEvaluables(evals);
				grammar.getRules().put(ruleName, rule);
				
				line = br.readLine();
			}
		    
		    // Closing streams
			br.close();
		    stream.close();
			
			
		} catch (IOException e) {
			Logger.getLogger( GrammarParserImpl.class.getName() ).log(Level.SEVERE, e.getMessage());
		}
		
		return grammar;
	}

	private void setRootRuleName(Grammar grammar, String ruleName) {
		if (grammar.getRootRule() == null){
			grammar.setRootRule(ruleName);
		}
	}

}
