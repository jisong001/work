package tt.login;

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

 * */
public class PatternMatcher {

	public static void main(String[] args) {
		new PatternMatcher().dowhile();//

	}
	//���
	public void dowhile() {
		
	}
	
	public void pp(Object o) {
		System.out.println(o);
	}
}
