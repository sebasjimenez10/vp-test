package com.grammar.poem.model;

import java.util.List;

/**
 * Rule model. Holds grammar attributes
 * 
 * @author sebastian
 *
 */
public class Rule {

    /**
     * Rule's name
     */
    private String name;

    /**
     * Rule's value
     */
    private String value;

    /**
     * Evaluable list of options
     */
    private List<List<String>> evaluables;

    public Rule() {
        // Constructor
    }

    /*
     * Getters and Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<List<String>> getEvaluables() {
        return evaluables;
    }

    public void setEvaluables(List<List<String>> evaluables) {
        this.evaluables = evaluables;
    }
}
