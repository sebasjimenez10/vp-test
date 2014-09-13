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

/**
 * Grammar Parser implementation test
 * @author sebastian
 *
 */
public class GrammarParserImplTest {

	private static final int NUMBER_OF_RULES = 7;
	private GrammarParserImpl gpi = new GrammarParserImpl();
	private List<String> expectedRuleNames;
	private List<String> expectedRuleValues;
	
	/**
	 * Tests that the grammar in 'poem.grammar' is successfully
	 * read.
	 * @throws IOException
	 */
	@Test
	public void testParseGrammar() throws IOException{
		// Arrange
		expectedRuleNames = new ArrayList<String>();
		expectedRuleValues = new ArrayList<String>();
		
		Collections.addAll(expectedRuleNames, "POEM", "LINE", "ADJECTIVE",
				"NOUN", "PRONOUN", "VERB", "PREPOSITION");
		
		Collections.addAll(expectedRuleValues, "<LINE> <LINE> <LINE> <LINE> <LINE>", 
				"<NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK",
				"black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END",
				"heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|"
				+ "tree|flower|field|meadow|pasture|harvest|water|father|mother|brother|"
				+ "sister <VERB>|<PREPOSITION>|$END",
				"my|your|his|her <NOUN>|<ADJECTIVE>",
				"runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|"
				+ "sinks <PREPOSITION>|<PRONOUN>|$END",
				"above|across|against|along|among|around|before|behind|beneath|beside|between|"
				+ "beyond|during|inside|onto|outside|under|underneath|upon|with|without|through"
				+ " <NOUN>|<PRONOUN>|<ADJECTIVE>");
		
		// Act
		Grammar grammar = gpi.parseGrammar("poem.grammar");
		Map<String, Rule> rules = grammar.getRules();
		
		
		// Assert
		assertThat( rules.size(), is(equalTo(NUMBER_OF_RULES)) );
		for (String rule : rules.keySet()) {
			assertThat( expectedRuleNames.contains(rule), is(equalTo(true)));
		}
		for (Rule rule : rules.values()) {
			assertThat( expectedRuleValues.contains( rule.getValue() ), is(equalTo(true)) );
		}
	}
	
}
