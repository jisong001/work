package tt.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * java.util.regex ����Ҫ�������������ࣺ
    Pattern �ࣺ
    pattern ������һ��������ʽ�ı����ʾ��Pattern ��û�й������췽����Ҫ����һ�� Pattern ������������ȵ����乫����̬���뷽����������һ�� Pattern ���󡣸÷�������һ��������ʽ��Ϊ���ĵ�һ��������
    Matcher �ࣺ
    Matcher �����Ƕ������ַ������н��ͺ�ƥ����������档��Pattern ��һ����Matcher Ҳû�й������췽��������Ҫ���� Pattern ����� matcher ���������һ�� Matcher ����
    PatternSyntaxException��
    PatternSyntaxException ��һ����ǿ���쳣�࣬����ʾһ��������ʽģʽ�е��﷨����
    
    Pattern������������õķ�����
	��1��boolean isMatch = Pattern.matches("regExp", "string");
		matches()������ʾ������ʽregExp�Ƿ�ƥ���ַ���string��ƥ�䷵��true����ƥ�䷵��false
	��2��Pattern pattern = Pattern.compile("regExp");
		compile()������ʾ�����������ʽregExp������regExp��������pattern

	Matcher�ೣ�õķ�����
	��1��������������ȷ���������ַ������������ҵ�ƥ�䣩
    	public int start() ������ǰƥ��ĳ�ʼ����
    	public int end() �������ƥ���ַ�֮���ƫ������
	��2���о�������������������ַ���������һ������ֵ����ʾ�Ƿ��ҵ���ģʽ��
    	public boolean lookingAt() ���Խ�������ͷ��ʼ�������������ģʽƥ�䡣
    	public boolean find() ���Բ������ģʽƥ����������е���һ�������С�
    	public boolean matches() ���Խ�����������ģʽƥ�䡣
	��3���滻�������滻�����ַ������ı��ķ�����
    	public String replaceAll(String replacement) �滻ģʽ������滻�ַ�����ƥ����������е�ÿ�������С�
    	public String replaceFirst(String replacement) �滻ģʽ������滻�ַ���ƥ����������еĵ�һ�������С�

   ������ʽ�Ĺ���ժҪ
 �ַ�
x	�ַ� x
\	��б���ַ�
n	���а˽���ֵ 0 ���ַ� n (0 <= n <= 7)
nn	���а˽���ֵ 0 ���ַ� nn (0 <= n <= 7)
mnn	���а˽���ֵ 0 ���ַ� mnn��0 <= m <= 3��0 <= n <= 7��
xhh	����ʮ������ֵ 0x ���ַ� hh
uhhhh	����ʮ������ֵ 0x ���ַ� hhhh
t	�Ʊ�� ('u0009')
n	���У����У��� ('u000A')
r	�س��� ('u000D')
f	��ҳ�� ('u000C')
a	���� (bell) �� ('u0007')
e	ת��� ('u001B')
cx	��Ӧ�� x �Ŀ��Ʒ�

�ַ���
[abc]	a��b �� c�����ࣩ
[^abc]	�κ��ַ������� a��b �� c���񶨣�
[a-zA-Z]	a �� z �� A �� Z����ͷ����ĸ�������ڣ���Χ��
[a-d[m-p]]	a �� d �� m �� p��[a-dm-p]��������
[a-z&&[def]]	d��e �� f��������
[a-z&&[^bc]]	a �� z������ b �� c��[ad-z]����ȥ��
[a-z&&[^m-p]]	a �� z������ m �� p��[a-lq-z]����ȥ��

Ԥ�����ַ���
.	�κ��ַ������н���������ƥ��Ҳ���ܲ�ƥ�䣩
d	���֣�[0-9]
D	�����֣� [^0-9]
s	�հ��ַ���[ tnx0Bfr]
S	�ǿհ��ַ���[^s]
w	�����ַ���[a-zA-Z_0-9]
W	�ǵ����ַ���[^w]

�߽�ƥ����
^	�еĿ�ͷ
$	�еĽ�β
b	���ʱ߽�
B	�ǵ��ʱ߽�
A	����Ŀ�ͷ
G	��һ��ƥ��Ľ�β
Z	����Ľ�β�����������Ľ�����������еĻ���
z	����Ľ�β

Greedy ������
X?	X��һ�λ�һ��Ҳû��
X*	X����λ���
X+	X��һ�λ���
X{n}	X��ǡ�� n ��
X{n,}	X������ n ��
X{n,m}	X������ n �Σ����ǲ����� m ��

Reluctant ������
X??	X��һ�λ�һ��Ҳû��
X*?	X����λ���
X+?	X��һ�λ���
X{n}?	X��ǡ�� n ��
X{n,}?	X������ n ��
X{n,m}?	X������ n �Σ����ǲ����� m ��

Possessive ������
X?+	X��һ�λ�һ��Ҳû��
X*+	X����λ���
X++	X��һ�λ���
X{n}+	X��ǡ�� n ��
X{n,}+	X������ n ��
X{n,m}+	X������ n �Σ����ǲ����� m ��

Logical �����
XY	X ��� Y
X|Y	X �� Y
(X)	X����Ϊ������

Back ����
n	�κ�ƥ��� nth������

����
	Nothing���������������ַ�
Q	Nothing���������������ַ���ֱ�� E
E	Nothing�����ǽ����� Q ��ʼ������

���⹹�죨�ǲ���
(?:X)	X����Ϊ�ǲ�����
(?idmsux-idmsux) 	Nothing�����ǽ�ƥ���־�� on תΪ off
(?idmsux-idmsux:X)  	X����Ϊ���и�����־ on - off �ķǲ�����
(?=X)	X��ͨ�����ȵ��� lookahead
(?!X)	X��ͨ�����ȵĸ� lookahead
(?<=X)	X��ͨ�����ȵ��� lookbehind
(?<!X)	X��ͨ�����ȵĸ� lookbehind
(?>X)	X����Ϊ�����ķǲ�����

 * */
public class PatternMatcher {

	public static void main(String[] args) {
		new PatternMatcher().dowhile();//

	}
	//���
	public void dowhile() {
		startEnd();
		lookingAt();
		replace();
		split();
	}
	//1��start �� end ����
	public void startEnd() {
		String REGEX = "\\bcat\\b";
	    String INPUT ="cat cat cat cattie cat";
	    Pattern p = Pattern.compile(REGEX);
	       Matcher m = p.matcher(INPUT); // ��ȡ matcher ����
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
	//matches �� lookingAt ��������������ƥ��һ����������ģʽ�����ǵĲ�ͬ�� matches Ҫ���������ж�ƥ�䣬��lookingAt ��Ҫ��
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
	//3��replaceFirst �� replaceAll ����
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
