package com.grammar.poem.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Grammar model. Holds Grammar attributes
 * 
 * @author sebastian
 *
 */
public class Grammar {

    public enum Keywords {
        $END("\r"), $LINEBREAK("\n");

        private String value;

        private Keywords(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    /**
     * Main or Root rule
     */
    private String rootRule;

    /**
     * Grammar set of rules
     */
    private Map<String, Rule> rules;

    public Grammar() {
        // Constructor
    }

    /*
     * Getters and Setters
     */

    public Map<String, Rule> getRules() {
        if (this.rules == null) {
            rules = new HashMap<String, Rule>();
        }
        return rules;
    }

    public void setRules(Map<String, Rule> rules) {
        this.rules = rules;
    }

    public String getRootRule() {
        return rootRule;
    }

    public void setRootRule(String rootRule) {
        this.rootRule = rootRule;
    }

}
