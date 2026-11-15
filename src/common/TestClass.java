package common;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestClass {
    @Test
    public void testMorseToLetter(){
        Converter converter = new Converter();
        String str = "..-.";

        String actual = converter.morseToEnglish(str);
        String expected = "F";

        assertEquals(expected, actual);
    }

    @Test
    public void testLetterToMorse(){
        Converter converter = new Converter();
        String str = "F";

        String actual = converter.englishToMorse(str);
        String expected = "..-.";

        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleLettersToMorse(){
        Converter converter = new Converter();
        String str = "HELLO WORLD";

        String actual = converter.englishToMorse(str);
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";

        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToMultipleLetters(){
        Converter converter = new Converter();
        String str = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";

        String actual = converter.morseToEnglish(str);
        String expected = "HELLOWORLD";

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyText(){
        Converter converter = new Converter();
        String str = "";

        assertThrows(IllegalArgumentException.class, () -> converter.englishToMorse(str));
    }

    @Test
    public void testInvalidMorse(){
        Converter converter = new Converter();
        String str = ".......";

        assertThrows(IllegalArgumentException.class, () -> converter.morseToEnglish(str));
    }

    @Test
    public void testInvalidCharacter(){
        Converter converter = new Converter();
        String str = " a-. -.";
        assertThrows(IllegalArgumentException.class, () -> converter.morseToEnglish(str));
    }
}
