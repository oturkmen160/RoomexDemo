package com.roomex.api.functions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class apiFunctions {

    public static int randomPostNum(int limit){
        Random random = new Random();

        return random.nextInt(limit) + 1;
    }

    public static boolean hasEmailValue(List<Map<String,Object>> listOfComments){
        //enter loop and check each email
        for(int i = 0; i < listOfComments.size(); i++){
            String email = (String) listOfComments.get(i).get("email");
            if(email == null || email == ""){
                return false;
            }

        }
        return true;
    }

    public static boolean hasValidEmailValue(List<Map<String,Object>> listOfComments)
    {
        //create email structure
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);

        for(int i = 0; i < listOfComments.size(); i++){
            String email = (String) listOfComments.get(i).get("email");
            //if email value does not match with the email pattern return false
            if(!pattern.matcher(email).matches()){
                return false;
            }
        }
        return true;
    }

}
