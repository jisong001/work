package tt.make.sql;

import tt.make.tool.FileUtil;
import tt.make.tool.NumberUtil;

public class OutSqlFile {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---- start -----");
		
		for(int i = 1 ; i<=364 ; i++) {
			OutSqlFile out = new OutSqlFile();
			FileUtil.writeFile(out.getSql(5000), "D:\\opo_insertBookHead_D_UD.sql");//  opo_insertBookHead
		}
		System.out.println("---- end -----");
	}

	String fStr="INSERT INTO \"COM_EMPLOYEE\" (\"COM_EMPLOYEE_ID\", \"HOSPITAL_ID\", \"EMPL_CODE\", \"EMPL_NAME\", \"SEX_CODE\", \"SPELL_CODE\", \"WB_CODE\", \"CUSTOM_CODE\", \"EMPL_CLASS\", \"POSI_CODE\", \"LEVEL_CODE\", \"VALID_STATE\", \"ADMIN_DEPT_CODE\", \"BUS_DEPT_CODE\", \"TEL\", \"DOCTORJOB_NO\", \"IDE_TYPE\", \"IDE_NO\", \"REMARK\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"OPER_CODE\", \"OPER_DATETIME\", \"COMPOUND_ID\") VALUES ('COM_EMP";
	String f2str="', '73736916-0', '";
	String f3str="', '";
	String f4str="', '2', 'WWW', 'GYB', NULL, '01', '600A', '101', '1', '0002', '0002', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0000', TO_DATE('20181220140000', 'YYYYMMDDHH24MISS'), '001');";
//	String f2str="', '73736916-0', '";
//	String f2str="', '73736916-0', '";
	String us1 ="INSERT INTO \"COM_USER\" (\"USER_ID\", \"ACCOUNT\", \"PASSWORD\", \"APP_ID\", \"EMPL_CODE\", \"EMPL_NAME\", \"IS_ADMIN\", \"VALID_STATE\", \"REMARK\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"SYN_FLAG\", \"OPER_CODE\", \"OPER_DATETIME\", \"IS_ROOT\", \"USER_LEVEL\", \"HOSPITAL_ID\", \"COMPOUND_ID\") VALUES ('User_";
	String us2 ="', '";
	String us3 ="', '$2a$10$f2fFb9yblQsU570R32ekoOi/G6Rs5sqzACGhUFlHrHeqmA7MRLsva', NULL, '";
	String us4 ="', '";
	String us5 ="', '0', '1', NULL, NULL, NULL, NULL, '0', 'init', TO_DATE('20010101160000', 'YYYYMMDDHH24MISS'), 0, NULL, '73736916-0', '001');";
	
	String g1 = "INSERT INTO \"COM_GRANT_TARGET\" (\"GRANT_TARGET_ID\", \"USER_ID\", \"DEPT_ID\", \"ROLE_ID\", \"OPER_CODE\", \"OPER_DATETIME\", \"HOSPITAL_ID\") VALUES ('";
	String g2 = "', '";
	String g3 = "', 'COM_DEPARTMENT_ID";
	String g4 = "', '006478f35c343afbc1b', 'init', TO_DATE('20191101151032', 'YYYYMMDDHH24MISS'), '73736916-0');";
	
	String cr1 = "INSERT INTO \"CDR_OPR_RADT_REGISTER\" (\"COM_RADT_REGISTERMAIN_ID\", \"REG_SN\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"CARD_TYPE\", \"CARD_NO\", \"PATIENT_ID\", \"PATIENT_NAME\", \"SEX_CODE\", \"BIRTH_DATE\", \"HEIGHT\", \"WEIGHT\", \"PATIENT_TEL\", \"IDE_TYPE\", \"IDE_NO\", \"LINKMAN_NAME\", \"LINKMAN_TEL\", \"LINKMAN_IDE_TYPE\", \"LINKMAN_IDE_NO\", \"CURR_PROV_CODE\", \"CURR_PROV_NAME\", \"CURR_CITY_CODE\", \"CURR_CITY_NAME\", \"CURR_DIST_CODE\", \"CURR_DIST_NAME\", \"CURR_OTHER\", \"SEE_DATE\", \"NOON_CODE\", \"NOON_NAME\", \"BEGIN_TIME\", \"END_TIME\", \"PAYKIND_CODE\", \"PAYKIND_NAME\", \"BOOK_FLAG\", \"DOCT_CODE\", \"DOCT_NAME\", \"DEPT_CODE\", \"DEPT_NAME\", \"CELL_CODE\", \"CELL_NAME\", \"ROOM_NO\", \"BED_NO\", \"SEE_NO\", \"REG_TYPE_CODE\", \"REG_TYPE_NAME\", \"VISIT_CLASS\", \"RESULT_CLASS\", \"OPER_CODE\", \"OPER_DATETIME\", \"REGIST_DATETIME\", \"OB_STATE\", \"OB_IN_DATETIME\", \"OB_OUT_DATETIME\", \"OB_OUT_REASON\", \"PATIENT_TYPE\", \"NAME_SPELL\", \"VERSION\") VALUES ('";
	String cr2 = "', 'GH20191101";
	String cr3 = "', '73736916-0', '001', '1', '";
	String cr4 = "', '";
	String cr5 = "', '2', TO_DATE('19680323080000', 'YYYYMMDDHH24MISS'), NULL, NULL, '13754537121', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), '4', '下夜', '00:00', '08:00', '1', '自费', '0', NULL, NULL, '0069', '内二科门诊', NULL, NULL, NULL, NULL, '1', '6', '普通医师', '04', NULL, '0486', TO_DATE('20190311111044', 'YYYYMMDDHH24MISS'), TO_DATE('20190311075838', 'YYYYMMDDHH24MISS'), NULL, NULL, NULL, NULL, '01', 'LUFENGMIAN', NULL);";
	
	String o1 = "INSERT INTO \"POE_OPO_ORDER\" (\"ORDER_SN\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"PATIENT_ID\", \"REG_SN\", \"SEE_SN\", \"RECIPE_NO\", \"RECIPE_TYPE\", \"SORT_NO\", \"ORDER_STATE_CLASS\", \"SYS_CLASS\", \"TERM_CODE\", \"TERM_NAME\", \"ENTRY_DATETIME\", \"ENTRY_OPER_CODE\", \"ENTRY_OPER_NAME\", \"ENTRY_DEPT_CODE\", \"ENTRY_DEPT_NAME\", \"EXEC_DEPT_CODE\", \"EXEC_DEPT_NAME\", \"STORE_DEPT_CODE\", \"STORE_DEPT_NAME\", \"COMB_NO\", \"COMB_SEQ_NO\", \"FREQUENCY_CODE\", \"FREQUENCY_NAME\", \"MO_NOTE\", \"REMARK\", \"INJECT_NUM\", \"USE_DAYS\", \"CHARGE_QTY\", \"CHARGE_BASE_QTY\", \"TERM_UNIT\", \"BASE_DOSE\", \"ONCE_DOSE\", \"DOSE_UNIT\", \"BASE_UNIT\", \"ONCE_DOSE_CLASS\", \"PACK_QTY\", \"PACK_UNIT\", \"SPECS\", \"DOSE_MODEL_CODE\", \"DOSE_MODEL_NAME\", \"DRUG_TYPE\", \"UNIT\", \"UNIT_CLASS\", \"UNIT_PRICE\", \"TEST_CLASS\", \"TEST_DESC\", \"TEST_OPTION\", \"TEST_DRUG_FLAG\", \"TEST_ORDER_SN\", \"MAIN_DRUG_FLAG\", \"USAGE_CODE\", \"USAGE_NAME\", \"USAGE_ENGLISH\", \"EMC_FLAG\", \"EXAM_METHOD_CODE\", \"EXAM_PART\", \"EXAM_PART_NAME\", \"ITEM_PART_SMALL\", \"LAB_SAMPLE\", \"LAB_SAMPLE_NAME\", \"DC_OPER_CODE\", \"DC_OPER_NAME\", \"DC_DATETIME\", \"LIMIT_LIQUID_SPEED\", \"SPECIAL_PROPERTY\", \"ONCE_DOSE_UNIT\", \"LIMIT_LIQUID_UNIT\", \"TOT_COST\", \"PRINT_FLAG\", \"APP_CLASS\", \"APP_CLASS_NAME\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"TERM_CLASS\", \"HERB_USAGE_CODE\", \"HERB_USAGE_NAME\", \"ANTIBIOTIC_TYPE\", \"ANTIBIOTIC_LEVEL\", \"FEE_CODE\", \"NEED_CONFIRM_FLAG\", \"ADAPTATION\") VALUES ('OO990";
	String o2 = "', '73736916-0', '001', 'PN00020061', 'GH990";
	String o3 = "', NULL, 'AN990";
	String o4 = "', NULL, 1, '01', '15', 'T000010488', '头部CT平扫', TO_DATE('20191101085759', 'YYYYMMDDHH24MISS'), '0244', '王建伟', '0069', '内二科门诊', '0019', 'CT', '0019', 'CT', 'OC201911010000086498', '1', '11', '即刻', NULL, NULL, NULL, 1, 1, NULL, '次', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '次', '01', 198, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '1', '0cbd717b552458fb7dc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 198, '0', '03', NULL, NULL, NULL, NULL, '01', NULL, NULL, NULL, NULL, NULL, '1', '1');";
	
	String i1 = "INSERT INTO \"POE_IPO_ORDER\" (\"ORDER_SN\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"PATIENT_ID\", \"INPATIENT_SN\", \"INPATIENT_NO\", \"LONG_FLAG\", \"DISCRIBE_FLAG\", \"ORDER_KIND\", \"ORDER_TYPE_CODE\", \"ORDER_TYPE_NAME\", \"ORDER_STATE_CLASS\", \"SYS_CLASS\", \"TERM_CODE\", \"TERM_NAME\", \"COMB_NO\", \"COMB_SEQ_NO\", \"SORT_NO\", \"EXEC_DEPT_CODE\", \"EXEC_DEPT_NAME\", \"STORE_DEPT_CODE\", \"STORE_DEPT_NAME\", \"BEGIN_DATETIME\", \"END_DATETIME\", \"ENTRY_DATETIME\", \"ENTRY_OPER_CODE\", \"ENTRY_OPER_NAME\", \"ENTRY_DEPT_CODE\", \"ENTRY_DEPT_NAME\", \"FIRST_ADDS\", \"FREQUENCY_CODE\", \"FREQUENCY_NAME\", \"MO_NOTE\", \"REMARK\", \"CHARGE_QTY\", \"CHARGE_BASE_QTY\", \"USE_DAYS\", \"TERM_UNIT\", \"BASE_DOSE\", \"ONCE_DOSE\", \"DOSE_UNIT\", \"BASE_UNIT\", \"ONCE_DOSE_CLASS\", \"PACK_QTY\", \"PACK_UNIT\", \"SPECS\", \"DOSE_MODEL_CODE\", \"DOSE_MODEL_NAME\", \"DRUG_TYPE\", \"UNIT\", \"UNIT_CLASS\", \"UNIT_PRICE\", \"TEST_FLAG\", \"TEST_CLASS\", \"TEST_DESC\", \"TEST_OPTION\", \"TEST_DRUG_FLAG\", \"TEST_ORDER_SN\", \"MAIN_DRUG_FLAG\", \"USAGE_CODE\", \"USAGE_NAME\", \"USAGE_ENGLISH\", \"EMC_FLAG\", \"EXAM_METHOD_CODE\", \"EXAM_PART\", \"EXAM_PART_NAME\", \"ITEM_PART_SMALL\", \"LAB_SAMPLE\", \"LAB_SAMPLE_NAME\", \"LIMIT_LIQUID_SPEED\", \"SPECIAL_PROPERTY\", \"ONCE_DOSE_UNIT\", \"LIMIT_LIQUID_UNIT\", \"APP_CLASS\", \"APP_CLASS_NAME\", \"CONFIRM_NURSE_CODE\", \"CONFIRM_NURSE_NAME\", \"CONFIRM_DATETIME\", \"DC_CLASS_CODE\", \"DC_CLASS_NAME\", \"DC_CONFIRM_NURSE_CODE\", \"DC_CONFIRM_NURSE_NAME\", \"DC_CONFRIM_DATETIME\", \"DC_OPER_CODE\", \"DC_OPER_NAME\", \"DC_DATETIME\", \"HERB_USAGE_CODE\", \"HERB_USAGE_NAME\", \"ANTIBIOTIC_TYPE\", \"ANTIBIOTIC_LEVEL\", \"FEE_CODE\", \"APPROVE_STATE\", \"APPROVE_NOTE\", \"CURMODC_DATETIME\", \"NXTMODC_DATETIME\", \"NEED_CONFIRM_FLAG\", \"INFORMED_CONSENT\", \"PATIENT_INFO_PROMPT\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"EXTEND_4\", \"EXTEND_5\", \"EXTEND_6\", \"PC_STATE\", \"ENTER_NUM\", \"RETURN_NUM\", \"ANTIBIOTIC_APPROVE_NAME\") VALUES ('IO990";
	String i2 = "', '73736916-0', '001', 'PN";
	String i3 = "', '501852201904131', '501852', '0', '0', '05', 'LZ', '临时医嘱', '04', '01', 'Y000824', '七叶洋地黄双苷滴眼液', 'IC201908180000089648', '1', 1, '0002', '内二科', '0065', '住院药房', TO_DATE('20190818143709', 'YYYYMMDDHH24MISS'), NULL, TO_DATE('20190818143709', 'YYYYMMDDHH24MISS'), '0244', '王建伟', '0002', '内二科', NULL, '11', '即刻', NULL, NULL, 1, 10, 1, '盒', 0, 1, 'ml', '支', '02', 10, '盒', '0.4ml', '25', '滴眼剂', '1', '盒', '04', 32.49, '0', NULL, NULL, NULL, NULL, NULL, NULL, '10', '含化', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N', 'ml', NULL, NULL, NULL, '0243', '杨阳', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '01', NULL, NULL, NULL, TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
	
	String bh1 = "INSERT INTO \"ODS_BOOK_OUT_HEAD\" (\"BOOK_SN\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"DRUG_FLAG\", \"REG_SN\", \"TOT_COST\", \"BALANCE_SN\", \"INVOICE_NO\", \"TRIAGE_SN\", \"BOOK_STATE\", \"BOOK_SOURCE\", \"RECIPE_NO\", \"RECIPE_CLASS\", \"ENTRY_DOCT_CODE\", \"ENTRY_DOCT_NAME\", \"ENTRY_DEPT_CODE\", \"ENTRY_DEPT_NAME\", \"ENTRY_DATETIME\", \"EMC_FLAG\", \"CLINIC_DIAGNOSE\", \"OPER_CODE\", \"OPER_DATETIME\", \"BOOK_LOCK\", \"ADAPTATION\") VALUES ('BK901";
	String bh2 = "', '73736916-0', '001', '2', 'GH901";
	String bh3 = "', 50, 'JS201909130000044825', NULL, NULL, '07', '02', 'R0012324', '01', '0244', '王建伟', '0069', '内二科门诊', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), '0', 'YN00703,感冒,1', '0244', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), 0, '1');";
	
	String bd1 = "INSERT INTO \"ODS_BOOK_OUT_DRUG_DETAIL\" (\"BOOK_SN\", \"RECIPE_NO\", \"SORT_NO\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"TRANS_TYPE\", \"SYS_CLASS\", \"TRADE_CLASS\", \"DRUG_CODE\", \"DRUG_NAME\", \"CADN_NAME\", \"PACK_SPECS\", \"BASE_SPECS\", \"AVG_PRICE\", \"CHARGE_QTY\", \"CHARGE_BASE_QTY\", \"UNIT_PRICE\", \"UNIT\", \"UNIT_CLASS\", \"TOT_COST\", \"BALANCE_SN\", \"INVOICE_NO\", \"EXEC_SN\", \"COMB_NO\", \"COMB_SEQ_NO\", \"INJECT_QTY\", \"LIMIT_LIQUID_SPEED\", \"LIMIT_LIQUID_UNIT\", \"TEST_DESC\", \"EXEC_DEPT_CODE\", \"EXEC_DEPT_NAME\", \"STORE_DEPT_CODE\", \"STORE_DEPT_NAME\", \"DOSE_MODEL_CODE\", \"HERB_USAGE_CODE\", \"HERB_USAGE_NAME\", \"DOSE_MODEL_NAME\", \"FREQ_CODE\", \"FREQ_NAME\", \"USAGE_CODE\", \"USAGE_NAME\", \"USE_DAYS\", \"ONCE_DOSE\", \"ONCE_DOSE_UNIT\", \"ONCE_DOSE_CLASS\", \"BASE_DOSE\", \"DOSE_UNIT\", \"BASE_UNIT\", \"PACK_QTY\", \"PACK_UNIT\", \"ORDER_SN\", \"REMARK\", \"TEST_OPTION\", \"TEST_DRUG_FLAG\", \"TEST_ORDER_SN\", \"TEST_CLASS\", \"APPLY_OPER\", \"RETURN_APPLY_DATETIME\", \"RETURN_REASON\", \"RETURN_DRUG_OPER\", \"RETURN_DRUG_DATETIME\", \"RETURN_FEE_OPER\", \"RETURN_FEE_DATETIME\", \"RETURN_DOSE_QTY\", \"FEE_CODE\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"RETURN_STATE\", \"OPER_CODE\", \"OPER_DATETIME\", \"CONFIRM_QTY\", \"ADAPTATION\") VALUES ('BK901";
	String bd2 = "', 'R0012324', 1, '73736916-0', '001', '1', '01', '2', 'Y000614', '阿莫西林胶囊', '阿莫西林胶囊', '0.25g', '0.25g', 2.50, 20, 400, 2.50, '盒', '04', 50, 'JS901909130000044825', NULL, 'OE901909130000075193', 'OC901909130000086700', '1', 0, NULL, NULL, NULL, '0017', '门诊药房', '0017', '门诊药房', '09', NULL, NULL, '胶囊剂', '01', '1/日', '1', '肌注(1ml)', 10, 10, 'g', '02', 0.25, 'g', '粒', 20, '盒', 'OO201909130000075193', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '01', NULL, NULL, NULL, NULL, '0244', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), 0, '1');";
	
	String bud1 = "INSERT INTO \"ODS_BOOK_OUT_UNDRUG_DETAIL\" (\"BOOK_SN\", \"APPLY_NO\", \"SORT_NO\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"ORDER_SN\", \"TRANS_TYPE\", \"TERM_CODE\", \"TERM_NAME\", \"NEED_CONFIRM_FLAG\", \"TERM_SPECS\", \"AVG_PRICE\", \"CHARGE_QTY\", \"UNIT_PRICE\", \"UNIT\", \"TOT_COST\", \"BALANCE_SN\", \"INVOICE_NO\", \"EXEC_SN\", \"COMB_NO\", \"COMB_SEQ_NO\", \"EXEC_DEPT_CODE\", \"EXEC_DEPT_NAME\", \"STORE_DEPT_CODE\", \"STORE_DEPT_NAME\", \"FREQ_CODE\", \"FREQ_NAME\", \"EXAM_PART\", \"TEST_DESC\", \"TEST_ORDER_SN\", \"REMARK\", \"EXTEND_1\", \"EXTEND_2\", \"EXTEND_3\", \"RETURN_STATE\", \"OPER_CODE\", \"OPER_DATETIME\", \"CONFIRMED_QTY\", \"ADAPTATION\") VALUES ('BK901";
	String bud2 = "', 'AN901909040000072646', 1, '73736916-0', '001', 'OO901909040000075151', '1', 'T000002660', '电解质系列', '1', NULL, 40, 1, 40, '次  ', 40, NULL, NULL, 'OE901909040000075151', 'OC901909040000086639', NULL, '0025', '检验', '0025', '检验', '01', '1/日', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '01', '0244', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'), 0, '1');";
	
	String ph1 = "INSERT INTO \"POE_PRIV_RECIPE_DOCT\" (\"PMR_ROLE_DETIAL_ID\", \"HOSPITAL_ID\", \"COMPOUND_ID\", \"EMPL_CODE\", \"EMPL_NAME\", \"RECIPE_PRIV_CODE\", \"RECIPE_PRIV_NAME\", \"VALID_STATE\", \"OPER_CODE\", \"OPER_DATETIME\") VALUES ('";
	String ph2 = "', '73736916-0', '001', '";
	String ph3 = "', '";
	String p1 = "', '2', '抗生素三级权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p2 = "', '3', '麻醉药品权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p3 = "', '4', '毒药品权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p4 = "', '5', '精神一药品权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p5 = "', '6', '精神二药品权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p6 = "', '0', '抗生素一级权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p7 = "', '1', '抗生素二级权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p8 = "', '7', '全院组套权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p9 = "', '8', '全科室组套权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	String p10 = "', '9', '处方开立权限', '1', '0245', TO_DATE('20191101000000', 'YYYYMMDDHH24MISS'));";
	
	
	
	public String getSql(int max) throws InterruptedException {
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=max;i++) {
			String id = NumberUtil.radom(i);
			String code = "9"+NumberUtil.fillZero(i, 3);
			String name = "User" + code;
//			String sql = fStr + code + f2str + code + f3str + name + f4str ;
//			String sql = us1 + code + us2 + code + us3 + code +us4 + name + us5 ;
//			String sql = g1 +id + g2 + name + g3 + getde(i) + g4;
//			String sql = cr1 + id + cr2 + code + cr3 + code + cr4 + code + cr4 + name + cr5;
//			String sql = o1 + id + o2 + id + o3+ id + o4;
//			String sql = i1 + id + i2 + code + i3;
			String sql = bh1 + id + bh2 + id + bh3 ;
			sb.append(sql).append("\r\n");
			sql = bd1 + id + bd2 ;
			sb.append(sql).append("\r\n");
			sql = bud1 + id + bud2 ;
			
			sb.append(sql).append("\r\n");
			
//			String sql = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p1;
//			sb.append(sql).append("\r\n");
//			String sql2 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p2;
//			sb.append(sql2).append("\r\n");
//			String sql3 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p3;
//			sb.append(sql3).append("\r\n");
//			String sql4 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p4;
//			sb.append(sql4).append("\r\n");
//			String sql5 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p5;
//			sb.append(sql5).append("\r\n");
//			String sql6 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p6;
//			sb.append(sql6).append("\r\n");
//			String sql7 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p7;
//			sb.append(sql7).append("\r\n");
//			String sql8 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p8;
//			sb.append(sql8).append("\r\n");
//			String sql9 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p9;
//			sb.append(sql9).append("\r\n");
//			String sql10 = ph1 + NumberUtil.radom(i) + ph2 + code + ph3 + name + p10;
//			sb.append(sql10).append("\r\n");
//			Thread.sleep(7);
		}
		Thread.sleep(3);
		return sb.toString();
	}
	private String getde(int i) {
		return (1+(i-1)/50)+"";
	}
}
