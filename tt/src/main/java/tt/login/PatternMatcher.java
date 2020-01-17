package tt.login;

/***
 * java.util.regex 包主要包括以下三个类：
    Pattern 类：
    pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
    Matcher 类：
    Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
    PatternSyntaxException：
    PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
    
    Pattern类中有两个最常用的方法：
	（1）boolean isMatch = Pattern.matches("regExp", "string");
		matches()方法表示正则表达式regExp是否匹配字符串string，匹配返回true，不匹配返回false
	（2）Pattern pattern = Pattern.compile("regExp");
		compile()方法表示编译此正则表达式regExp，返回regExp被编译后的pattern

	Matcher类常用的方法：
	（1）索引方法（精确表明输入字符串中在哪能找到匹配）
    	public int start() 返回以前匹配的初始索引
    	public int end() 返回最后匹配字符之后的偏移量。
	（2）研究方法（用来检查输入字符串并返回一个布尔值，表示是否找到该模式）
    	public boolean lookingAt() 尝试将从区域开头开始的输入序列与该模式匹配。
    	public boolean find() 尝试查找与该模式匹配的输入序列的下一个子序列。
    	public boolean matches() 尝试将整个区域与模式匹配。
	（3）替换方法（替换输入字符串里文本的方法）
    	public String replaceAll(String replacement) 替换模式与给定替换字符串相匹配的输入序列的每个子序列。
    	public String replaceFirst(String replacement) 替换模式与给定替换字符串匹配的输入序列的第一个子序列。

 * */
public class PatternMatcher {

	public static void main(String[] args) {
		new PatternMatcher().dowhile();//

	}
	//入口
	public void dowhile() {
		
	}
	
	public void pp(Object o) {
		System.out.println(o);
	}
}
