package com.grammar.poem.parser.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class GrammarParserImplTest extends TestCase {

	private GrammarParserImpl gpi = new GrammarParserImpl();
	private List<String> expectedRuleNames;
	
	@Test
	public void test(){
		// Arrange
		expectedRuleNames = new ArrayList<String>();
		Collections.addAll(expectedRuleNames, "POEM", "LINE", "ADJECTIVE",
				"NOUN", "PRONOUN", "VERB", "PREPOSITION");
		
		// Act
		Grammar grammar = gpi.parseGrammar("poem.grammar");
		Map<String, Rule> rules = grammar.getRules();
		
		// Assert
		assertThat( rules.size(), is(equalTo(7)) );
		for (String rule : rules.keySet()) {
			assertThat( expectedRuleNames, hasItem(rule) );
		}
	}
	
}