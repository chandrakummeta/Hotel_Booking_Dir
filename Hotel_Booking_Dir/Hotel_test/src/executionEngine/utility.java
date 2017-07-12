//----------------------------------------------------------------
//AUTHOR NAME :- Pooja Chawla
//Objective:  matcher utility to match a string in a sentence
//CREATED DATE :- 11/07/2017
//VERSION :- 1.0
//===============================================================

package executionEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class utility 
{
	public static boolean matcher(String matchstring,String sentence) throws Exception
	{
	
		String patternString = matchstring;
		int flag=0;
		Pattern pattern  = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(sentence);
		while(matcher.find())
		{
			
			flag=1;
			break;
			
		}
		if(flag==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
