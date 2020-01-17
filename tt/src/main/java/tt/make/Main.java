package tt.make;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().test();;
	}

	public void test() {
		int westernMedicineNum = 5;
		List<String> orderList = new ArrayList<String>();
		for(int i = 0 ;i<3 ;i++) {
			orderList.add("aa"+i);
		}
		this.pp(orderList);
		int iSize = orderList.size();
		List<String> tempList = new ArrayList<String>();
		for(int i = 0 ; i< iSize; i++  ) {
			if( (i+1)%westernMedicineNum == 0) {
				tempList.add(orderList.get(i));
				this.pp(tempList);
				tempList.clear();
			}else {
				tempList.add(orderList.get(i));
			}			
		}
		this.pp(tempList);
	}
	
	public void pp(List<String> t) {
		StringBuffer sb = new StringBuffer();
		for(String s :t) {
			sb.append(s).append(",");
		}
		System.out.println(sb.toString());
	}
}
