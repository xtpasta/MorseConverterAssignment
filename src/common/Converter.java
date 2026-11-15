package common;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    // Hashmap
    Map<Character, String> englishToMorse;
    Map<String, Character> morseToEnglish;

    public Converter() {
        englishToMorse = new HashMap<>();
        morseToEnglish = new HashMap<>();

        addMap('A', ".-");
        addMap('B', "-...");
        addMap('C', "-.-.");
        addMap('D', "-..");
        addMap('E', ".");
        addMap('F', "..-.");
        addMap('G', "--.");
        addMap('H', "....");
        addMap('I', "..");
        addMap('J', ".---");
        addMap('K', "-.-");
        addMap('L', ".-..");
        addMap('M', "--");
        addMap('N', "-.");
        addMap('O', "---");
        addMap('P', ".--.");
        addMap('Q', "--.-");
        addMap('R', ".-.");
        addMap('S', "...");
        addMap('T', "-");
        addMap('U', "..-");
        addMap('V', "...-");
        addMap('W', ".--");
        addMap('X', "-..-");
        addMap('Y', "-.--");
        addMap('Z', "--..");
    }

    private void addMap(char letter, String morse){
        englishToMorse.put(letter, morse);
        morseToEnglish.put(morse, letter);
    }

    // English to morse
    public String englishToMorse(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        }

        StringBuilder result = new StringBuilder();

        text = text.toUpperCase();

        for (char letter : text.toCharArray()) {
            if (letter == ' ') {
                continue;
            }

            if (!englishToMorse.containsKey(letter)) {
                throw new IllegalArgumentException("Invalid character " + letter);
            }

            result.append(englishToMorse.get(letter));
            result.append(' ');
        }
        return result.toString().trim();
    }


    // Morse to english
    public String morseToEnglish(String morse) {
        if (morse == null || morse.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        }

        String[] codes = morse.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String code : codes) {
            if (!code.matches("[.-]+")){
                throw new IllegalArgumentException("Invalid Morse " + code);
            }

            if (!morseToEnglish.containsKey(code)){
                throw new IllegalArgumentException("Morse does not exist " + code);
            }
            result.append(morseToEnglish.get(code));
        }

        return result.toString().trim();
    }
}
