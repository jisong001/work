package tt.make.tool;

import java.io.File;

import tt.make.sql.Main;
import tt.make.tool.DateUtil;
import tt.make.tool.FileUtil;

public class TestSQLMaker {


	private static String nowStr = "";
	private static int startIndex = 1;
	private static int endIndex = 500;
	private static String PATH = "E:\\workspace\\work_eclipse\\speech-demo-master\\sql";
	private static String FILENAME_ADD = "insert.sql";
	private static String FILENAME_DEL = "delete.sql";
	public static void main(String[] args) {
		
		/*
		 * 
		 	select t.*, t.rowid from CDR_IPR_REGISTER t where t.inpatient_sn in ('502425201910291', '900000000000001', '500216201903131');
			select t.*, t.rowid from FIN_IPR_REGISTER t where t.inpatient_sn  in ('502425201910291', '900000000000001');
			select t.*, t.rowid from Main t where t.inpatient_sn in ('502425201910291', '900000000000001');
			select t.*, t.rowid from FIN_IPF_ACCOUNT t where t.inpatient_sn in ('502425201910291', '900000000000001');
			select t.*, t.rowid from POE_IPO_ORDER t where t.inpatient_sn in ('502425201910291', '900000000000001');
		 */
		
		nowStr = DateUtil.getStringDateYYYYMMDD();
		StringBuffer sb_add = new StringBuffer();
		StringBuffer sb_del = new StringBuffer();
		
		//CDR_IPR_REGISTER
		new Main(startIndex, endIndex, nowStr);
		String CDR_IPR_REGISTER_addSQL = Main.getSql_insert();
		String CDR_IPR_REGISTER_delSQL = Main.getSql_delete();
//		System.out.println(CDR_IPR_REGISTER_addSQL);
//		System.out.println(CDR_IPR_REGISTER_delSQL);
		sb_add.append("--CDR_IPR_REGISTER\r\n");
		sb_add.append(CDR_IPR_REGISTER_addSQL);
		sb_add.append("\r\n");
		sb_del.append("--CDR_IPR_REGISTER\r\n");
		sb_del.append(CDR_IPR_REGISTER_delSQL);
		sb_del.append("\r\n");
		
		//FIN_IPR_REGISTER
		new Main(startIndex, endIndex, nowStr);
		String FIN_IPR_REGISTER_addSQL = Main.getSql_insert();
		String FIN_IPR_REGISTER_delSQL = Main.getSql_delete();
//		System.out.println(FIN_IPR_REGISTER_addSQL);
//		System.out.println(FIN_IPR_REGISTER_delSQL);
		sb_add.append("--FIN_IPR_REGISTER\r\n");
		sb_add.append(FIN_IPR_REGISTER_addSQL);
		sb_add.append("\r\n");
		sb_del.append("--FIN_IPR_REGISTER\r\n");
		sb_del.append(FIN_IPR_REGISTER_delSQL);
		sb_del.append("\r\n");
		
		//Main
		new Main(startIndex, endIndex, nowStr);
		String Main_addSQL = Main.getSql_insert();
		String Main_delSQL = Main.getSql_delete();
//		System.out.println(Main_addSQL);
//		System.out.println(Main_delSQL);
		sb_add.append("--Main\r\n");
		sb_add.append(Main_addSQL);
		sb_add.append("\r\n");
		sb_del.append("--Main\r\n");
		sb_del.append(Main_delSQL);
		sb_del.append("\r\n");
		
		//FIN_IPF_ACCOUNT
//		new FIN_IPF_ACCOUNT(startIndex, endIndex, nowStr);
//		String FIN_IPF_ACCOUNT_addSQL = FIN_IPF_ACCOUNT.getSql_insert();
//		String FIN_IPF_ACCOUNT_delSQL = FIN_IPF_ACCOUNT.getSql_delete();
////		System.out.println(FIN_IPF_ACCOUNT_addSQL);
////		System.out.println(FIN_IPF_ACCOUNT_delSQL);
//		sb_add.append("--FIN_IPF_ACCOUNT\r\n");
//		sb_add.append(FIN_IPF_ACCOUNT_addSQL);
//		sb_add.append("\r\n");
//		sb_del.append("--FIN_IPF_ACCOUNT\r\n");
//		sb_del.append(FIN_IPF_ACCOUNT_delSQL);
//		sb_del.append("\r\n");
		
		//FIN_IPF_ACCOUNT
//		new POE_IPO_ORDER(startIndex, endIndex, nowStr);
//		String POE_IPO_ORDER_addSQL = POE_IPO_ORDER.getSql_insert();
//		String POE_IPO_ORDER_delSQL = POE_IPO_ORDER.getSql_delete();
////		System.out.println(POE_IPO_ORDER_addSQL);
////		System.out.println(POE_IPO_ORDER_delSQL);
//		sb_add.append("--POE_IPO_ORDER\r\n");
//		sb_add.append(POE_IPO_ORDER_addSQL);
//		sb_add.append("\r\n");
//		sb_del.append("--POE_IPO_ORDER\r\n");
//		sb_del.append(POE_IPO_ORDER_delSQL);
//		sb_del.append("\r\n");
//		
//		sb_add.append("commit;");
//		sb_del.append("commit;");
//		
//		FileUtil.writeFile(sb_add.toString(), PATH + File.separator + FILENAME_ADD);
//		FileUtil.writeFile(sb_del.toString(), PATH + File.separator + FILENAME_DEL);
	}

}
