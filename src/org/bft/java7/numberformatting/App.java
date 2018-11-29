package org.bft.java7.numberformatting;

public class App {

	public static void main(String[] args) {
        /**
         * Supported in int
         * */
        int improvedInt = 10_00_000;
        int improvedIntConsecutivesUnderscores = 10___00______000;
        
        System.out.println(improvedInt); // 1000000
        System.out.println(improvedIntConsecutivesUnderscores); // 1000000
 
        /**
         * Supported in float
         * */
        float improvedFloat = 10_00_000f;
        System.out.println(improvedFloat); // 1000000.0
        
        /**
         * Supported in long
         * */
        float improvedLong = 10_00_000l;
        System.out.println(improvedLong); // 1000000.0
 
        /**
         * Supported in double
         * */
        float improvedDouble = 10_00_000;
        System.out.println(improvedDouble); // 1000000.0
        
        /**
         * Not supported
         */
        /*
        int notSupportedIntWithUnderscoresAtTheLastOfNumber = 1000_;
        float NotSupportedFloatWithUnderscoresAfterDot = 10._000f;
        float NotSupportedFloatWithUnderscoresBeforeDot = 10_.000f;
        */
        
        
	}
}
