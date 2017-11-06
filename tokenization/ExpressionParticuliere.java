package tokenization;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParticuliere {
private static Matcher matcher;
public static ArrayList<Pattern> patterns =  new ArrayList<Pattern>();
	
	public static int isExpression(String s){
		for (int i = 0; i < patterns.size(); i++){
			matcher = ((Pattern) patterns.get(i)).matcher(s);
			if(matcher.find())
				return i;
		}
		return -1;
	}
	
	public static void create(){
		patterns.add(Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")); //date
		patterns.add(Pattern.compile("^(?:https?:\\/\\/)?(?:[\\w]+\\.)([a-zA-Z\\.]{2,6})([\\/\\w\\.-]*)*\\/?")); //url
		patterns.add(Pattern.compile("^[0-9]+$")); //nombres
	}
	
	public static int size(){
		return patterns.size();
	}
}
