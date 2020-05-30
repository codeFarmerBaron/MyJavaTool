package test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import baron.util.date.DateFormatEnum;
import baron.util.date.DateTool;


public class Test{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date a =new Date();
		LocalDateTime b =LocalDateTime.now();
		System.out.println(DateTool.toDateStr(a, DateFormatEnum.DATE_DEFAULT_US));
		System.out.println(a.toString());
	}
	public static void absMinus(int a, int ...b){
		System.out.println(a);
		System.out.println(Arrays.toString(b));
	}

	
}
