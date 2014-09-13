package com.grammar.poem.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;

public class GrammarParserImplTest {

	private GrammarParserImpl gpi = new GrammarParserImpl();
	private List<String> expectedRuleNames;
	
	@Test
	public void test() throws IOException{
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
			assertThat( expectedRuleNames.contains(rule), is(equalTo(true)));
		}
	}
	
}
