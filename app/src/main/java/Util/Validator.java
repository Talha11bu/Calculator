package Util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {

    public boolean isValid(String check){
        String regex = "(\\(*\\-?\\)*[0-9]+(\\.[0-9]+)?\\)*)+((\\(*|[+\\-/*^%])\\)?\\-?\\)*[0-9]+(\\.[0-9]+)?\\)*)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(check);
        return matcher.matches();
    }
    
}
