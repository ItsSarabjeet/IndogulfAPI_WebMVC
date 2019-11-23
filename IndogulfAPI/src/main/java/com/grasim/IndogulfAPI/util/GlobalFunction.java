package com.grasim.IndogulfAPI.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class GlobalFunction {

	/*
	 * Covert to json
	 */
	public String convert_to_json(Object object){
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = null;
		try {			 
			//System.out.println(mapper.writeValueAsString(object));
			jsonData = mapper.writeValueAsString(object);	
		} catch (JsonGenerationException e) {	 
			e.printStackTrace();	 
		} catch (JsonMappingException e) {	 
			e.printStackTrace();	 
		} catch (IOException e) {	 
			e.printStackTrace();	 
		}	 
		return jsonData;		
	}
	
	/*
	 * Generate random Integer
	 */  
	public String RandomInteger(){
		log("Generating Random Number");	
		String random_no = null;
		Random random = new Random();	      
	    // get next long value 
	    long LOWER_RANGE = 10000000000L; //assign lower range value
	    long UPPER_RANGE = 100000000000L; //assign upper range value
	    long value = LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		log("Generated : " + value+"");
		random_no = value+"";
		return random_no;
	}
	
	public static void log(String aMessage){
	    System.out.println(aMessage);
	}
	/*
	 * Covert String date into Date
	 */
	public Date convertDate(String stringDate,String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {	 
			date = formatter.parse(stringDate);			 
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(date);	
		return date;
	}
	
	public String getRandomString() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();       
        return saltStr;
    }

	public String RandomSmallInteger(){
		log("Generating Random Number");	
		String random_no = null;
		Random random = new Random();	      
	    // get next long value 
	    long LOWER_RANGE = 1000L; //assign lower range value
	    long UPPER_RANGE = 10000L; //assign upper range value
	    long value = LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		log("Generated : " + value+"");
		random_no = value+"";
		return random_no;
	}
	
	public String getamountindigits(String amount)
	{
		String amountindigits="";
		String x=amount;
		if(x.length()<=3)
		{
			amountindigits= x;
		}else
		{
        x=x.toString();
        String lastThree = x.substring(x.length()-3);
        String otherNumbers = x.substring(0,x.length()-3);
        if(otherNumbers != "")
            lastThree = "," + lastThree;
        
        amountindigits = otherNumbers.replaceAll("(?<=\\d)(?=(\\d{2})+$)", ",") + lastThree;
		}
		return amountindigits;
	}
}
