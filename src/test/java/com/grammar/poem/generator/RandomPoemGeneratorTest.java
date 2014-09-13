package com.grammar.poem.generator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.grammar.poem.model.Grammar;
import com.grammar.poem.model.Rule;

@RunWith(MockitoJUnitRunner.class)
public class RandomPoemGeneratorTest {
	
	// Constants
	private static final String ROOT_RULE_KEY = "ROOTRULE";
	private static final String ROOT_RULE_NAME = "<ROOTRULE>";
	private static final String $END = "$END";
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	// Mocks
	@Mock
	private Grammar grammar;
	@Mock
	private Rule rule;
	
	// Private attrs
	private Map<String, Rule> rules;
	private List<List<String>> evaluables;
	private List<String> options1;
	private List<String> options2;
	
	@Before
	public void setup(){
		// Changing system out
		System.setOut(new PrintStream( outContent ));
		
		// Initializing lists, maps and list of lists
		rules = new HashMap<String, Rule>();
		options1 = new ArrayList<String>();
		options2 = new ArrayList<String>();
		evaluables = new ArrayList<List<String>>();
		
		// Adding test data
		rules.put(ROOT_RULE_KEY, rule);
		Collections.addAll(options1, "word1", "word2");
		Collections.addAll(options2, ROOT_RULE_NAME, $END);
		Collections.addAll(evaluables, options1, options2);
		
		// Configuring mocks
		doReturn( rules ).when( grammar ).getRules();
		doReturn( ROOT_RULE_KEY ).when( grammar ).getRootRule();
		doReturn( evaluables ).when( rule ).getEvaluables();
		
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	@Test
	public final void testGeneratePoem() {
		RandomPoemGenerator.generatePoem(grammar);
		assertThat( outContent.toString().matches("[word1\\s|word2\\s]+"), is(equalTo(true)) );
	}

}
