Poem Generator
===

Disclaimer:
> This project is related to a technical test. This content is published to make the review process easier.

> There's is no intention to let others plagiarize this solution.

Introduction
---

The design and programming exercise is to create a random poem generator using the
following grammatical rules:

```
POEM: <LINE> <LINE> <LINE> <LINE> <LINE>
LINE: <NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK
ADJECTIVE: black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END
NOUN: heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|
tree|flower|field|meadow|pasture|harvest|water|father|mother|brother|sister <VERB>|<PREPOSITION>|$END
PRONOUN: my|your|his|her <NOUN>|<ADJECTIVE>
VERB: runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|$END
PREPOSITION: above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>
```

- To the left of the colon is the name of the rule.
- To the right of the colon is the rule definition which can consist of words, keywords and references to other rules.
- A reference to another rule is marked with angle brackets, for example <NOUN>. Rules can reference themselves, making them recursive.
- Keywords are marked with $. There are two keywords: ```LINEBREAK``` and ```END```. ```LINEBREAK``` adds a line break to the output, ```END``` marks that the end of a line has been reached. This means that a line can only end with an adjective, a noun or a verb.
- A grouping of elements separated by | means that one of those elements should be 
selected at random.
- Anything else that is plain text can be considered a word, for example murky or 
heart. 

For example, the rule PRONOUN is defined as my|your|his|her <NOUN>|<ADJECTIVE> which
means that one of the words my, your, his or her should be selected at random followed by
either a NOUN or an ADJECTIVE, also selected at random.

#### Problem Statement

Write a Java program which parses the grammatical rules from a text file, then uses the parsed data to generate a random poem. Here is an example of what the output might look like:

```
my sun among her white meadow
moon upon my light
moon
your rain climbs
her murky bright clear willow
```

Instructions
---

#### Installation:

1. Open a terminal window
2. Clone the repository somewhere in your pc using ```git clone https://github.com/sebasjimenez10/vp-test.git```
3. Move into the new directory created using ```cd vp-test```
4. Use the following maven command to package the project into a ```.jar``` file: ```mvn package```
5. After that, a ```poem-1.0.jar``` jar will be generated.

#### Execution:

1. To execute the program you must type ```java -jar poem-1.0.jar``` in the terminal window
2. A poem like this one will be generated:
```
during her black black murky 
brother with her harvest 
beside murky 
pasture descends 
his muddy field stands your field
```

#### Program Options:

- You can execute the program with two options: ```-g``` and ```-f:<file>```
- ```-g``` option is a flag that can be used to tell the program to print the grammar that is being used.
- ```-f:<file>``` is a option that can be used to change the grammar file for another one.
- Both options can be used simultaniously

Some examples:

- ```java -jar poem-1.0.jar -g```
- ```java -jar poem-1.0.jar -f:new.grammar```
- ```java -jar poem-1.0.jar -g -f:new.grammar```

#### Program Requirements:

- The file ```poem.grammar``` must be in the same directoy as the ```.jar``` file to work by default
- If you want to provide a different grammar file please use the ```-f:<file>``` option

#### Source folder structure:
```
src/
├── main
│   └── java
│       └── com
│           └── grammar
│               └── poem
│                   ├── generator
│                   │   └── RandomPoemGenerator.java
│                   ├── Main.java
│                   ├── model
│                   │   ├── Grammar.java
│                   │   └── Rule.java
│                   └── parser
│                       ├── GrammarParser.java
│                       └── impl
│                           └── GrammarParserImpl.java
└── test
    └── java
        └── com
            └── grammar
                └── poem
                    ├── generator
                    │   └── RandomPoemGeneratorTest.java
                    └── parser
                        └── impl
                            └── GrammarParserImplTest.java

17 directories, 8 files
```

#### Technical Requirements:

This projects was developed using [Maven](http://maven.apache.org/), [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html), [JUnit](http://junit.org/), [Hamcrest](https://github.com/hamcrest), [Mockito](https://code.google.com/p/mockito/) and [Eclipse Luna](https://www.eclipse.org/)

Maven version:
```
Apache Maven 3.0.5
Maven home: /usr/share/maven
Java version: 1.7.0_67, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-oracle/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.13.0-35-generic", arch: "i386", family: "unix"
```

Java version:
```
java version "1.7.0_67"
Java(TM) SE Runtime Environment (build 1.7.0_67-b01)
Java HotSpot(TM) Server VM (build 24.65-b04, mixed mode)
```