package com.stone.study.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class JXLExcelUtil {
	/**
	 * @description: 导出excel
	 * @param columns 列名
	 * @param titles
	 * @param datas
	 * @param sheetName
	 * @param output
	 * @throws Exception
	 * @author 石涛
	 * @throws IOException 
	 * @throws WriteException 
	 * @date 2014-12-9
	 * @-- ------------------------------------------------
	 * @xx 修改人修改日期 修改描述
	 * @xx 石涛 2014-12-9 创建
	 * @-- ------------------------------------------------
	 * @Version Ver1.0
	 */
	public static void exportExcel(List<String> columns, List<String> titles,
			List<Map<String, Object>> datas, String sheetName,
			OutputStream output) throws IOException, WriteException  {
		WritableWorkbook workbook = Workbook.createWorkbook(output);
		WritableSheet sheet = workbook.createSheet(sheetName, 0);
		WritableCellFormat titleFormat = new WritableCellFormat();
		titleFormat.setBackground(Colour.GRAY_25);
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setAlignment(Alignment.CENTRE);
		for (int i = 0; i < titles.size(); i++) {
			Label title = new Label(i, 0, titles.get(i), titleFormat);
			sheet.addCell(title);
			sheet.setColumnView(i, 15);
		}
		for (int i = 0; i < datas.size(); i++) {
			for (int j = 0; j < columns.size(); j++) {
				Label label = new Label(j, i + 1, datas.get(i).get(
						columns.get(j))
						+ "");
//				System.out.println("[" + j + "," + (i + 1) + "]"
//						+ datas.get(i).get(columns.get(j)) + " ");
				sheet.addCell(label);
			}
		}
		workbook.write();
		workbook.close();
	}
	
	public static List<?> importExcel(InputStream in) throws BiffException, IOException{
		//主要字段：id、姓名、联系电话、营销区域编码、营销区域、区域调度人姓名、区域调度人联系方式
		Workbook workbook = Workbook.getWorkbook(in);
		if(null==workbook){//没有读取到文件
			return null;
		}
		//获取工作表对象
		Sheet[] sheet = workbook.getSheets();
		if(null==sheet || sheet.length<1){//没有读取到工作表
			return null;
		}
		//循环工作表
		for(int i=0;i<sheet.length;i++){
			//获得工作表的行数
			int rowNum = sheet[i].getRows();
			for(int j=0;j<rowNum;j++){//遍历工作表行
				//得到当前的所有单元格
				Cell[] cells = sheet[i].getRow(j);
				if(null==cells || cells.length<1){//当前行没有单元格
					return null;
				}
				for(int k=0;k<cells.length;k++){//遍历单元格
					//读取单元格的值
					String cellVal = cells[k].getContents();
					System.out.println(cellVal);
				}
			}
		}
		//关闭资源、释放内存
		workbook.close();
		return null;
	}
	public static void main(String[] args) {
	}
}
