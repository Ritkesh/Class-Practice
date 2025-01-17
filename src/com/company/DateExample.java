package com.company;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

// create class DateExample to add Days to the given date
class DateExample{
    //main() method start
    public static void main(String args[]){

        // create old date in string format
        String dateBefore = "2021-07-10";
        System.out.println(dateBefore+" is the date before adding days");

        // create instance of the SimpleDateFormat that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //create instance of the Calendar class and set the date to the given date
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(dateBefore));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 180);
        String dateAfter = sdf.format(cal.getTime());

        //date after adding three days to the given date
        System.out.println(dateAfter+" is the date after adding 36 days.");
        String greeting = """
    Hello, World!
    
    
    
    
    
    
    Welcome to Java 17 Text Blocks.
    """;
        System.out.println(greeting);

        String json = """
    {
        "name": "John",
        "age": 30,
        "city": "New York"
    }
    """;
        System.out.println(json);



    }
}




