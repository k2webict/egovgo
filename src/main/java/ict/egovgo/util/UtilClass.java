package ict.egovgo.util;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;


public class UtilClass {
	
	public static void main(String[] args) {
		
		HWPFile hwpFile;
		String hwpText;
		try {
		    hwpFile = HWPReader.fromFile("C:/temp/test.hwp");
		    hwpText = TextExtractor.extract(hwpFile, TextExtractMethod.InsertControlTextBetweenParagraphText);
		 
		    System.out.println("===== hwp text extractor =====");
		    System.out.println("hwpText = " + hwpText);
		} catch (Exception e) {
		    e.printStackTrace();
		} 

		
	}

}
