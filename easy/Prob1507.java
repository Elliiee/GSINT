package easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1507 {
    private static final Map<String, String> months = getMonths();

    //regular expression 
    public String reformatDate(String date){
        String[] str = date.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(str[2]).append("-");
        sb.append(months.get(str[1])).append("-");
        sb.append(str[0].length() == 3 ? ("0" + str[0].substring(0, 1)) : str[0].substring(0, 2));
        return sb.toString();
    }

    private static Map<String, String> getMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }

    public static void main(String[] args){
        String date = "20th Oct 2052";
        Prob1507 p = new Prob1507();
        String result = p.reformatDate(date);
        System.out.println("Reformed \"20th Oct 2052\" : " + result);
    }
}
/*
 * Reformat Date
 * Given a date string in the form Day Month Year, where:
    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    Year is in the range [1900, 2100].
    Convert the date string to the format YYYY-MM-DD, where:
    YYYY denotes the 4 digit year.
    MM denotes the 2 digit month.
    DD denotes the 2 digit day.
 */

 /*
  * \\s: This represents a whitespace character. 
    It matches any whitespace character such as a space, tab, newline, etc. 
    The double backslash is used to escape the backslash in Java strings, 
    so that it is interpreted correctly as a single backslash by the regular expression engine.
    +: This is a quantifier that means "one or more" of the preceding element.
  */
