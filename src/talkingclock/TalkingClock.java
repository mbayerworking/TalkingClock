/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talkingclock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author morgan
 */
public class TalkingClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        System.out.print("Enter time: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        String s = br.readLine();
        String[] parts = s.split(":");
        String output = clockConvert(parts[0],parts[1]);
        System.out.println(output);
    }

    private static String clockConvert(String hours, String minutes) {
        String[] hoursWords = new String[]{"twelve ","one ","two ","three ","four ","five ","six ","seven ","eight ","nine ","ten ","eleven ","twelve "};
        String[] minuteBaseWords = new String[]{"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
        String[] minuteTensWords = new String[]{"","","twenty ","thirty ","fourty ","fifty "};
        String[] seperatorWords = new String[]{"", "oh "};
        String[] amPm = new String[]{"am","pm"};
        String timeOfDay = "";
        Integer h = Integer.parseInt(hours);
        Integer m = Integer.parseInt(minutes);
        if(h >= 12 )
        {
            h -= 12;
            timeOfDay = amPm[1];
        }
        else {
            timeOfDay = amPm[0];
        }
        int[] hArray = getDigits(h);
        int[] mArray = getDigits(m);
        
        System.out.println(Arrays.toString(hArray));
        System.out.println(Arrays.toString(mArray));
        String output = "It's ";
        
        // Check hours
        output += hoursWords[h];
        if (mArray[0] == 0 && mArray[1] == 0)
        {
            output += seperatorWords[0];
        }
        else if(mArray[0] == 0 && mArray[1] != 0){
            output += seperatorWords[1] + minuteBaseWords[mArray[1]];
        }
        else {
            output += minuteTensWords[mArray[0]] + minuteBaseWords[mArray[1]];
        }
        output += timeOfDay;
        
        return output;
    }

    private static int[] getDigits(Integer num) {
        int[] list = new int[2];
        list[0] = num / 10;
        list[1] = num % 10;
        return list;
    }
    
    
    
}
