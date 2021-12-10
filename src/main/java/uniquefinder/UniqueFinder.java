package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> getUniqueChars (String text){
        if (text == null){
            throw new IllegalArgumentException("Text is null.");
        }

        List<Character> characterList = new ArrayList<>();
        for (char c: text.toCharArray()){
            if (!characterList.contains(c)){
                characterList.add(c);
            }
        }
        return characterList;
    }
}
