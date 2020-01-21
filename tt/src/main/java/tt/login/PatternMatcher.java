package tt.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

   正则表达式的构造摘要
 字符
x	字符 x
\	反斜线字符
n	带有八进制值 0 的字符 n (0 <= n <= 7)
nn	带有八进制值 0 的字符 nn (0 <= n <= 7)
mnn	带有八进制值 0 的字符 mnn（0 <= m <= 3、0 <= n <= 7）
xhh	带有十六进制值 0x 的字符 hh
uhhhh	带有十六进制值 0x 的字符 hhhh
t	制表符 ('u0009')
n	新行（换行）符 ('u000A')
r	回车符 ('u000D')
f	换页符 ('u000C')
a	报警 (bell) 符 ('u0007')
e	转义符 ('u001B')
cx	对应于 x 的控制符

字符类
[abc]	a、b 或 c（简单类）
[^abc]	任何字符，除了 a、b 或 c（否定）
[a-zA-Z]	a 到 z 或 A 到 Z，两头的字母包括在内（范围）
[a-d[m-p]]	a 到 d 或 m 到 p：[a-dm-p]（并集）
[a-z&&[def]]	d、e 或 f（交集）
[a-z&&[^bc]]	a 到 z，除了 b 和 c：[ad-z]（减去）
[a-z&&[^m-p]]	a 到 z，而非 m 到 p：[a-lq-z]（减去）

预定义字符类
.	任何字符（与行结束符可能匹配也可能不匹配）
d	数字：[0-9]
D	非数字： [^0-9]
s	空白字符：[ tnx0Bfr]
S	非空白字符：[^s]
w	单词字符：[a-zA-Z_0-9]
W	非单词字符：[^w]

边界匹配器
^	行的开头
$	行的结尾
b	单词边界
B	非单词边界
A	输入的开头
G	上一个匹配的结尾
Z	输入的结尾，仅用于最后的结束符（如果有的话）
z	输入的结尾

Greedy 数量词
X?	X，一次或一次也没有
X*	X，零次或多次
X+	X，一次或多次
X{n}	X，恰好 n 次
X{n,}	X，至少 n 次
X{n,m}	X，至少 n 次，但是不超过 m 次

Reluctant 数量词
X??	X，一次或一次也没有
X*?	X，零次或多次
X+?	X，一次或多次
X{n}?	X，恰好 n 次
X{n,}?	X，至少 n 次
X{n,m}?	X，至少 n 次，但是不超过 m 次

Possessive 数量词
X?+	X，一次或一次也没有
X*+	X，零次或多次
X++	X，一次或多次
X{n}+	X，恰好 n 次
X{n,}+	X，至少 n 次
X{n,m}+	X，至少 n 次，但是不超过 m 次

Logical 运算符
XY	X 后跟 Y
X|Y	X 或 Y
(X)	X，作为捕获组

Back 引用
n	任何匹配的 nth捕获组

引用
	Nothing，但是引用以下字符
Q	Nothing，但是引用所有字符，直到 E
E	Nothing，但是结束从 Q 开始的引用

特殊构造（非捕获）
(?:X)	X，作为非捕获组
(?idmsux-idmsux) 	Nothing，但是将匹配标志由 on 转为 off
(?idmsux-idmsux:X)  	X，作为带有给定标志 on - off 的非捕获组
(?=X)	X，通过零宽度的正 lookahead
(?!X)	X，通过零宽度的负 lookahead
(?<=X)	X，通过零宽度的正 lookbehind
(?<!X)	X，通过零宽度的负 lookbehind
(?>X)	X，作为独立的非捕获组

 * */
public class PatternMatcher {

	public static void main(String[] args) {
		new PatternMatcher().dowhile();//

	}
	//入口
	public void dowhile() {
		startEnd();
		lookingAt();
		replace();
		split();
	}
	//1、start 和 end 方法
	public void startEnd() {
		String REGEX = "\\bcat\\b";
	    String INPUT ="cat cat cat cattie cat";
	    Pattern p = Pattern.compile(REGEX);
	       Matcher m = p.matcher(INPUT); // 获取 matcher 对象
	       int count = 0;	 
	       while(m.find()) {
	         count++;
	         pp("Match number "+count);
	         pp("start(): "+m.start());
	         pp("end(): "+m.end());
	         pp("m.toStr: "+m.toString());
	         pp("s_e: "+INPUT.substring(m.start(), m.end()));	         
	      }
	}
	//2, lookingAt
	//matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求
	public void lookingAt() {
		String REGEX = "foo";
		String INPUT = "fooooooooooooooooo";
		String INPUT2 = "ooooofoooooooooooo";
		Pattern pattern;
		Matcher matcher;
		Matcher matcher2;
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);
		matcher2 = pattern.matcher(INPUT2);

		pp("matcher.lookingAt(): " + matcher.lookingAt());
		pp("matcher.matches(): " + matcher.matches());
		pp("matcher2.lookingAt(): " + matcher2.lookingAt());
		pp("matcher2.matches(): " + matcher2.matches());
	}
	//3、replaceFirst 和 replaceAll 方法
	//
	public void replace() {
		String REGEX = "dog";
		String INPUT = "The dog says meow. All dogs say meow.";
		String REPLACE = "cat";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);
		pp(INPUT);
	}
	//split
	public void split() {
		String regex = "[+\\-*/]";
        Pattern pattern = Pattern.compile(regex);
        String []nums = pattern.split("13+29-44*55/22");
        for (String num : nums) {
            System.out.print(num + " ");
        }
        pp("");
	}
	
	public void pp(Object o) {
		System.out.println(o);
	}
}
