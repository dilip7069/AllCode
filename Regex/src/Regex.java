
import java.util.regex.*;
public class Regex {

	public static void main(String[] args)
	{
		
		Pattern p =  Pattern.compile("...");
		Matcher m = p.matcher("Dilip is a mad guy Dilip");
		while(m.find())
			System.out.println(m.group());
		
		/*Pattern p =  Pattern.compile("\\s");
		String[] s = p.split("ab ab ab b");
		for(String s1:s)
			System.out.println(s1);*/
		
		
	}
}