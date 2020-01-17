package tt.make.sql;

import tt.make.tool.NumberUtil;

public class Main {

	private static String sql_insert = null;
	private static String sql_delete = null;
	
	private static int index_start = 1;
	private static int index_end = 50;
	private static String now_str = "";
	
	private static String ODS_IPR_REGISTER_ID = "00000000000000000";
	private static String INPATIENT_SN = "00000000000000000";
	private static String INPATIENT_NO = "";
	private static String PATIENT_ID = "";
	private static String PATIENT_NAME = "";
	private static String DEPT_CODE = "0002";
	private static String DEPT_NAME = "内二科";
	private static String NURSE_CELL_CODE = "0043";
	private static String NURSE_CELL_NAME = "内二病区";
	private static String BED_NO = "+93";
	private static String BED_CODE = "0043_+93";
	private static String ROOM_NO = "159";
	
	private static String sql_insert_template = "insert into CDR_IPR_REGISTER "
			+ "(ODS_IPR_REGISTER_ID, INPATIENT_SN, HOSPITAL_ID, COMPOUND_ID, INPATIENT_NO, IN_TIMES, EMPI_ID, PATIENT_ID, PAYKIND_CODE, "
			+ "PAYKIND_NAME, PATIENT_NAME, SEX_CODE, NATION_CODE, BIRTH_DATE, IDE_TYPE, IDE_NO, HOME_TEL, MARRIAGE_CODE, PROFESSION_CODE, "
			+ "HAVE_BABY_FLAG, BABY_FLAG, HEIGHT, WEIGHT, DEPT_CODE, DEPT_NAME, NURSE_CELL_CODE, NURSE_CELL_NAME, BED_NO, BED_CODE, "
			+ "ROOM_NO, CURR_PROV_CODE, CURR_PROV_NAME, CURR_CITY_CODE, CURR_CITY_NAME, CURR_DIST_CODE, CURR_DIST_NAME, "
			+ "CURR_OTHER, REGED_PROV_CODE, REGED_PROV_NAME, REGED_CITY_CODE, REGED_CITY_NAME, REGED_DIST_CODE, "
			+ "REGED_DIST_NAME, REGED_OTHER, BIRTH_PROV_CODE, BIRTH_PROV_NAME, BIRTH_CITY_CODE, BIRTH_CITY_NAME, "
			+ "BIRTH_DIST_CODE, BIRTH_DIST_NAME, BIRTH_OTHER, ORIGIN_PROV_CODE, ORIGIN_PROV_NAME, ORIGIN_CITY_CODE, "
			+ "ORIGIN_CITY_NAME, COMPANY, LINKMAN_NAME, LINKMAN_TEL, LINKMAN_IDE_TYPE, LINKMAN_IDE_NO, LINKMAN_RELATION_CODE, "
			+ "LINKMAN_RELATION_NAME, LINKMAN_ADDR, IN_DATETIME, IN_DEPT_CODE, IN_DEPT_NAME, IN_ROOM_NO, IN_CELL_CODE, "
			+ "IN_CELL_NAME, OUT_DATETIME, OUT_DEPT_CODE, OUT_DEPT_NAME, OUT_ROOM_NO, OUT_CELL_CODE, OUT_CELL_NAME, "
			+ "RECEIVE_DOCT_CODE, RECEIVE_DOCT_NAME, CLINIC_DIAGNOSE_CODE, CLINIC_DIAGNOSE_NAME, IN_SOURCE, IN_CONDITION, "
			+ "IN_PATH, IN_STATE, OPER_CODE, OPER_DATETIME, HOUSE_DOCT_CODE, HOUSE_DOCT_NAME, ATTENDING_DOCT_CODE, ATTENDING_DOCT_NAME, "
			+ "CHIEF_DOCT_CODE, CHIEF_DOCT_NAME, DUTY_NURSE_CODE, DUTY_NURSE_NAME, TEND_LEVEL_NAME, CONDITION_DESC, "
			+ "DIET, LAST_BEDFEE_DATETIME, CONDITION_CLASS, TEND_LEVEL_CLASS, RECEPTION_OPER_CODE, RECEPTION_OPER_DATETIME, RESULT_CLASS, "
			+ "EXTEND_1, EXTEND_2, EXTEND_3, POOR_FLAG, PATIENT_AGE) values \r\n";
/*	private String values = "values ('99999', '900000000000001', '73736916-0', '001', '100001', '1', null, 'PN00020782', '1', '自费', 
 * '测试100001', '2', null, to_date('29-10-1996 08:00:00', 'dd-mm-yyyy hh24:mi:ss'), '01', null, '13941596999', null, null, '0', 
 * '0', null, null, '0008', '妇产科', '0050', '妇产科病区', '16', '0050_16', '8', null, null, null, null, null, null, null, null, 
 * null, null, null, null, null, '营口', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
 * null, null, null, null, to_date('29-10-2019 18:58:56', 'dd-mm-yyyy hh24:mi:ss'), '0008', '妇产科', null, '0050', '妇产科病区', 
 * null, null, null, null, null, null, '0156', '刘明月', 'Q84.500', '指[趾]甲增大和增生', '2', '3', '2', 'I', '0120', 
 * to_date('29-10-2019 19:54:00', 'dd-mm-yyyy hh24:mi:ss'), '0149', '吕志昌', '0149', '吕志昌', '0150', '刘化江', '0151', '焦丽娃', 
 * null, null, null, null, null, null, '0120', to_date('29-10-2019 19:54:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, '0', '23');";*/
	private static String values_template = "(':ODS_IPR_REGISTER_ID', ':INPATIENT_SN', '73736916-0', '001', ':INPATIENT_NO', '1', null, ':PATIENT_ID', '1', '自费', "
			+ "':PATIENT_NAME', '2', null, to_date('29-10-1996 08:00:00', 'dd-mm-yyyy hh24:mi:ss'), '01', null, '13941596999', null, null, '0', '0', null, "
			+ "null, ':DEPT_CODE', ':DEPT_NAME', ':NURSE_CELL_CODE', ':NURSE_CELL_NAME', ':BED_NO', ':BED_CODE', ':ROOM_NO', null, null, null, null, "
			+ "null, null, null, null, null, null, null, null, null,"
			+ " '营口', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "
			+ "to_date('29-10-2019 18:58:56', 'dd-mm-yyyy hh24:mi:ss'), ':DEPT_CODE', ':DEPT_NAME', null, ':NURSE_CELL_CODE', ':NURSE_CELL_NAME', "
			+ "null, null, null, null, null, null, '0245', '王文卫', null, '先天性眉畸形', '0', '1', '2', 'I', "
			+ "'0243', to_date('29-10-2019 19:54:00', 'dd-mm-yyyy hh24:mi:ss'), '0149', '吕志昌', '0149', '吕志昌', '0150', '刘化江', '0151', '焦丽娃', "
			+ "null, null, null, null, null, null, '0120', to_date('29-10-2019 19:54:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, '0', '23');\r\n ";
	
	private static String sql_delete_template = "delete CDR_IPR_REGISTER where ODS_IPR_REGISTER_ID = ':ODS_IPR_REGISTER_ID'; \r\n";
	
	
	public static void main(String[] args) {
		loop();
	}
	
	
	public Main() {
		loop();
	}
	public Main(int startIndex, int endIndex, String nowStr) {
		index_start = startIndex;
		index_end = endIndex;
		now_str = nowStr;
		loop();
	}
	
	public static String make(int index) {
		String newValue = values_template
				.replace(":ODS_IPR_REGISTER_ID", ODS_IPR_REGISTER_ID) //99999
				.replace(":INPATIENT_SN", INPATIENT_SN) //900000000000001
				.replace(":INPATIENT_NO", INPATIENT_NO) //100001
				.replace(":PATIENT_ID", PATIENT_ID) //PN00020782
				.replace(":PATIENT_NAME", PATIENT_NAME) //测试100001
				.replace(":DEPT_CODE", DEPT_CODE) //:0002
				.replace(":DEPT_NAME", DEPT_NAME) //内二科
				.replace(":NURSE_CELL_CODE", NURSE_CELL_CODE) //:0043
				.replace(":NURSE_CELL_NAME", NURSE_CELL_NAME) //内二病区
				.replace(":BED_NO", BED_NO) //+93
				.replace(":BED_CODE", BED_CODE) //0043_+93
				.replace(":ROOM_NO", ROOM_NO) //90
				;
		
		return newValue;
	}
	
	public static void loop() {
		StringBuffer sb_insert = new StringBuffer();
		StringBuffer sb_delete = new StringBuffer();
		for (int i = index_start; i <= index_end; i++) {
			
			String endStr = NumberUtil.fillZero(i, Integer.toString(index_end).length());
			
			ODS_IPR_REGISTER_ID = "40000000000000000" + endStr;    //da297144ca54c9a8813
			INPATIENT_NO = "400" + endStr;   //502425  
			INPATIENT_SN = INPATIENT_NO + now_str; //502425201910291
			PATIENT_ID = "CS00" + INPATIENT_NO; //PN00000004;                              
			PATIENT_NAME = "T患者" + endStr;                            
//			DEPT_CODE = "";                               
//			DEPT_NAME = "";                               
//			NURSE_CELL_CODE = "";                         
//			NURSE_CELL_NAME = "";                         
			BED_NO = "+T" + endStr ;//+93
			BED_CODE = NURSE_CELL_CODE + "_" + BED_NO;//0043_+93
//			ROOM_NO = "";//159
			
			
			String value = make(i);
			sb_insert.append(sql_insert_template);
			sb_insert.append(value);
			
			sb_delete.append(sql_delete_template.replace(":ODS_IPR_REGISTER_ID", ODS_IPR_REGISTER_ID));
		}
//		System.out.println(sb_insert.toString());
//		System.out.println(sb_delete.toString());
		
		sql_insert = sb_insert.toString();
		sql_delete = sb_delete.toString();
	}

	public static String getSql_insert() {
		return sql_insert;
	}


	public static String getSql_delete() {
		return sql_delete;
	}

	
}
