package tt.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTwo {

	public static void main(String[] args) {
		String str = "1234name=asdf; key=123456; value=hjkhjk;";
		String spx = "(.*?)=(.*?)";
		Pattern pat = Pattern.compile(spx);
		Matcher mat = pat.matcher(str);
		mat.find();
		pp(mat.groupCount());
		pp(mat.group(2));
		pp(mat.replaceAll("kkkk "));
		pp(str.matches("(.[1~9]*?)"));
	}

	public static void pp(Object o) {
		System.out.println(" -->  "+o);
	};
}

