package baron.util.date;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <h2>UTF-8</h2>
 * <h2>处理Date日期、LocalDateTime日期相关的工具类：</h2>
 * 1，Date、LocalDateTime、指定格式时间字符串、时间戳，相互转换；<br>
 * 2，以时间戳、日期字符串、年月日数字为数据源，新建Date日期类型；<br>
 * 3，Date日期加减年、月、日、时、分、秒；<br>
 * 4，获取当天起始、末尾时间，当月起始、末尾时间。<br>
 * 
 * <h2>注意：</h2>
 * 1，LocalDateTime为时区敏感，本工具类皆以“+8”时区为准，未采用系统默认时区；<br>
 * 2，当LocalDateTime、Date以“+8”时区为准和时间戳转换时，0毫秒时间戳为1970-01-01 08:00:00；<br>
 * 3，日期字符串转成日期类时注意格式字母的大小写;<br>
 * 4，LocalDateTime不支持zzz时间格式。<br>
 * 
 * <h2>关于时间格式：</h2>
 * 1，年：y。1~2个表示两位年数字，3~4个表示四位年数，4个以上在年数字之前补（n-4）个0，如"YYYYYY"即"001999"；<br>
 * 2，月：M。1~2个表示两位月数字，3个及以上表示月份文字，如“十月”或“October”(看时区环境)，并且M的个数表示保留的文字个数；<br>
 * 3，日：d。1~2个表示1~2位日期数字，3个及以上在日期数字前补（n-2）个0；<br>
 * 4，星期：E。中文不限个数显示如“星期二”，英文3个及以下表示星期缩写，3个以上表示全称；<br>
 * 5，时：H/h。小写h1~2个表示1~2位12小时制小时数字，大写H1~2个都表示2位24小时制数字；h/H 3个及以上在数字前补（n-2）个0；<br>
 * 6，分：m。1~2个表示1~2位分钟数字，超过两位则在结果前补满"0"；<br>
 * 7，秒：s。1~2个表示1~2位秒数字，超过两位则在结果前补满"0"；<br>
 * 8，毫秒：SSS。1~3个表示1~3位毫秒数字，超过两位则在结果前补满"0"；<br>
 * 9，时间标准：zzz。如GMT、CST。<br>
 * @author Baron
 * @version 0.0.2
 * @since java8
 * @time 2020/5/30
 *
 */
public final class DateTool implements Serializable {

	/**
	 * Serialization 版本
	 */
	private static final long serialVersionUID = -1104331057077877553L;

	/**
	 * 隐藏默认构造器
	 */
	private DateTool(){}

	//-----------------------------------------------------------------------
	/**
	 * Date类型转成LocalDateTime类型（+8时区）
	 * @param date 日期
	 * @return LocalDateTime
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		if (date==null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.of("+8"));
	}


	/**
	 * 毫秒秒级时间戳转成LocalDateTime（注意“+8”时区0时间戳为1970-01-01 08:00:00）
	 * @param timeStampMilli 毫秒级时间戳
	 * @return LocalDateTime
	 */
	public static LocalDateTime toLocalDateTime(Long timeStampMilli){
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStampMilli), ZoneOffset.of("+8"));
	}

	/**
	 * 毫秒秒级时间戳转成LocalDateTime（注意“+8”时区0时间戳为1970-01-01 08:00:00）
	 * @param timeStampMilli 毫秒级时间戳
	 * @return LocalDateTime
	 */
	public static LocalDateTime toLocalDateTime(String timeStampMilli){
		return toLocalDateTime(Long.valueOf(timeStampMilli));
	}

	/**
	 * String格式日期转成LocalDateTime
	 * @param localDateTimeStr 如“1970-01-01”类的日期字符串
	 * @param format 格式字符串：y年， M月，d日，H时(不可小写)，m分，s秒。<br>
	 * 注意大小写，且保证dateString和format格式一致。
	 * @return LocalDateTime
	 */
	public static LocalDateTime toLocalDateTime(String localDateTimeStr,String format) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
		return LocalDateTime.parse(localDateTimeStr,df);
	}


	//-----------------------------------------------------------------------
	/**
	 * LocalDateTime类型转成Date类型（+8时区）
	 * @param localDateTime 日期
	 * @return Date
	 */
	public static Date toDate(LocalDateTime localDateTime){
		if (localDateTime==null) {
			return null;
		}
		return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
	}

	/**
	 * 毫秒级时间戳转成date日期
	 * @param timeStampSecond 毫秒级时间戳
	 * @return Date
	 */
	public static Date toDate(Long timeStampMilli){
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(timeStampMilli);
		return calendar.getTime();
	}

	/**
	 * 毫秒级时间戳转成date日期
	 * @param timeStampMilli 毫秒级时间戳
	 * @return Date
	 */
	public static Date toDate(String timeStampMilli){
		return toDate(Long.valueOf(timeStampMilli));
	}

	/**
	 * String格式日期转成Date
	 * @param dateStr 如“1970-01-01”类的日期字符串
	 * @param format 格式字符串：y年， M月，d日，h/H时，m分，s秒。注意大小写，且保证dateString和format格式一致。
	 * @return Date日期
	 * @throws ParseException 日期转化异常
	 */
	public static Date toDate(String dateStr,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}

	//-----------------------------------------------------------------------
	/**
	 * date日期转成秒级时间戳
	 * @param date 日期
	 * @return 秒级时间戳
	 */
	public static Long toTimestampSecond(Date date){
		if (date==null) {
			return -1L;
		}
		return date.getTime();
	}

	/**
	 * date日期转成毫秒级时间戳
	 * @param date 日期
	 * @return 毫秒级时间戳
	 */
	public static Long toTimeStampMilli(Date date){
		if (date==null) {
			return -1L;
		}
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}


	/**
	 * LocalDateTime日期转成秒级时间戳（+8时区）
	 * @param localDateTime 日期
	 * @return 秒级时间戳
	 */
	public static Long toTimestampSecond(LocalDateTime localDateTime){
		if (localDateTime==null) {
			return -1L;
		}
		return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
	}

	/**
	 * LocalDateTime日期转成毫秒级时间戳（+8时区）
	 * @param localDateTime 日期
	 * @return 毫秒级时间戳
	 */
	public static Long toTimeStampMilli(LocalDateTime localDateTime){
		if (localDateTime==null) {
			return -1L;
		}
		return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

	//-----------------------------------------------------------------------
	/**
	 * Date日期转成String格式
	 * @param date 日期
	 * @param format 格式字符串：y年， M月，d日，H时(大写24制,小写12制)，m分，s秒。注意大小写。
	 * @return 日期字符串
	 */
	public static String toDateStr(Date date,String format) {
		if (date==null) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 根据指定格式将日期转成字符串
	 * @param date 指定日期
	 * @param formatEnum 指定格式
	 * @return 对应格式字符串
	 */
	public static String toDateStr(Date date,DateFormatEnum formatEnum) {
		if (date==null) {
			return null;
		}
		if(formatEnum.toString().endsWith("US")){
			return new SimpleDateFormat(formatEnum.getContent(),Locale.US).format(date);
		}else{
			return new SimpleDateFormat(formatEnum.getContent()).format(date);
		}
	}
	
	/**
	 * LocalDateTime日期转成String格式
	 * @param localDateTime 日期
	 * @param format 格式字符串：y年， M月，d日，H时(大写24制,小写12制)，m分，s秒。注意大小写。
	 * @return 日期字符串
	 */
	public static String toDateStr(LocalDateTime localDateTime,String format) {
		if (localDateTime==null) {
			return null;
		}
		return DateTimeFormatter.ofPattern(format).format(localDateTime);
	}
	
	/**
	 * 根据指定格式将日期转成字符串
	 * @param localDateTime 指定日期
	 * @param formatEnum 指定格式，注意不使用带“zzz”的格式，localDateTime并不支持
	 * @return 对应格式字符串
	 */
	public static String toDateStr(LocalDateTime localDateTime,DateFormatEnum formatEnum) {
		if (localDateTime==null) {
			return null;
		}
//		if(formatEnum.toString().endsWith("US")){
//			return DateTimeFormatter.ofPattern(formatEnum.getContent(),Locale.US).format(localDateTime);
//		}else{
			return DateTimeFormatter.ofPattern(formatEnum.getContent()).format(localDateTime);
//		}
	}

	/**
	 * 把毫秒级时间戳转成时间字符串，注意0毫秒时间戳对应的时间为1970-01-01 08:00:00 。
	 * @param timeStampMilli 毫秒级时间戳
	 * @param format 格式字符串：y年， M月，d日，H时(大写24制,小写12制)，m分，s秒。注意大小写。
	 * @return 日期字符串
	 */
	public static String toDateStr(Long timeStampMilli,String format) {
		return toDateStr(toLocalDateTime(timeStampMilli), format);
	}
	
	/**
	 * 把毫秒级时间戳转成时间字符串，注意0毫秒时间戳对应的时间为1970-01-01 08:00:00 。
	 * @param timeStampMilli 毫秒级时间戳
	 * @param formatEnum 指定格式
	 * @return 日期字符串
	 */
	public static String toDateStr(Long timeStampMilli,DateFormatEnum formatEnum) {
		return toDateStr(toLocalDateTime(timeStampMilli), formatEnum.getContent());
	}

	/**
	 * 把formatFrom格式的日期字符串转成formatTo格式
	 * @param dateStr 日期字符串
	 * @param formatFrom 日期源格式，需和dateString格式相同。字符串：y年， M月，d日，H时（不可小写），m分，s秒。
	 * @param formatTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(String dateStr,String formatFrom,String formatTo){
		return toDateStr(toLocalDateTime(dateStr, formatFrom), formatTo);
	}
	
	/**
	 * 把formatFrom格式的日期字符串转成formatTo格式
	 * @param dateStr 日期字符串
	 * @param formatEnumFrom 日期源格式
	 * @param formatEnumTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(String dateStr,DateFormatEnum formatEnumFrom,DateFormatEnum formatEnumTo){
		return toDateStr(toLocalDateTime(dateStr, formatEnumFrom.getContent()), formatEnumTo.getContent());
	}

	/**
	 * 把毫秒级时间戳转成formatTo格式日期字符串
	 * @param timeStampMilli 毫秒级时间戳
	 * @param formatTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(String timeStampMilli,String formatTo){
		LocalDateTime localDateTime=toLocalDateTime(timeStampMilli);
		return toDateStr(localDateTime, formatTo);
	}
	
	/**
	 * 把毫秒级时间戳转成formatTo格式日期字符串
	 * @param timeStampMilli 毫秒级时间戳
	 * @param formatEnumTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(String timeStampMilli,DateFormatEnum formatEnumTo){
		LocalDateTime localDateTime=toLocalDateTime(timeStampMilli);
		return toDateStr(localDateTime, formatEnumTo.getContent());
	}

	/**
	 * 把毫秒级时间戳转成formatTo格式日期字符串
	 * @param timeStampMilli 毫秒级时间戳
	 * @param formatTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(Long timeStampMilli,String formatTo){
		LocalDateTime localDateTime=toLocalDateTime(timeStampMilli);
		return toDateStr(localDateTime, formatTo);
	}
	
	/**
	 * 把毫秒级时间戳转成formatTo格式日期字符串
	 * @param timeStampMilli 毫秒级时间戳
	 * @param formatEnumTo 想要转成的日期格式
	 * @return 日期字符串
	 */
	public static String tranDateStr(Long timeStampMilli,DateFormatEnum formatEnumTo){
		LocalDateTime localDateTime=toLocalDateTime(timeStampMilli);
		return toDateStr(localDateTime, formatEnumTo.getContent());
	}


	//-----------------------------------------------------------------------
	/**
	 * 根据输入（数组）数据生成Date日期
	 * @param times 根据输入长度自动设置为年、月、日、时、分、秒、毫秒（7项），长度小于7时，日期补“1”，时间补“0”。
	 * @return Date日期
	 */
	public static Date getDate(int...times){
		if (times==null||times.length==0) {
			return new Date();
		}
		int[] timesNew=new int[7];
		for (int i = 0; i < timesNew.length; i++) {
			if (i <times.length) {
				timesNew[i]=times[i];
			}else{
				if (i<3) {
					timesNew[i]=1;
				}else{
					timesNew[i]=0;
				}
			}
		}
		Calendar calendar = Calendar.getInstance();	
		calendar.set(Calendar.YEAR,timesNew[0]);
		calendar.set(Calendar.MONTH,timesNew[1]-1);
		calendar.set(Calendar.DAY_OF_MONTH,timesNew[2]);
		calendar.set(Calendar.HOUR_OF_DAY, timesNew[3]);
		calendar.set(Calendar.MINUTE, timesNew[4]);
		calendar.set(Calendar.SECOND, timesNew[5]);
		calendar.set(Calendar.MILLISECOND, timesNew[6]);
		return calendar.getTime();
	}

	/**
	 * Date日期加上（负数减去）一段时间
	 * @param date 原始日期
	 * @param calenderType Calendar 类型，如Calendar.YEAR为年
	 * @param time 变化的时间长度，如Calendar.YEAR、-2：两年前
	 * @return 新的Date日期
	 */
	public static Date add(Date date,int calenderType,int time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calenderType, time);
		return calendar.getTime();
	} 

	/**
	 * Date日期加上（负数减去）N年
	 * @param date 原始日期
	 * @param year 正加负减
	 * @return 新的Date日期
	 */
	public static Date addYear(Date date,int year){
		return add(date,Calendar.YEAR, year);
	} 

	/**
	 * Date日期加上（负数减去）N月
	 * @param date 原始日期
	 * @param month 正加负减
	 * @return 新的Date日期
	 */
	public static Date addMonth(Date date,int month){
		return add(date,Calendar.MONTH, month);
	} 

	/**
	 * Date日期加上（负数减去）N天
	 * @param date 原始日期
	 * @param day 正加负减
	 * @return 新的Date日期
	 */
	public static Date addDay(Date date,int day){
		return add(date,Calendar.DAY_OF_MONTH, day);
	} 

	/**
	 * Date日期加上（负数减去）N小时
	 * @param hour 原始日期
	 * @param year 正加负减
	 * @return 新的Date日期
	 */
	public static Date addHour(Date date,int hour){
		return add(date,Calendar.HOUR, hour);
	} 

	/**
	 * Date日期加上（负数减去）N分钟
	 * @param date 原始日期
	 * @param minute 正加负减
	 * @return 新的Date日期
	 */
	public static Date addMinute(Date date,int minute){
		return add(date,Calendar.MINUTE, minute);
	} 

	/**
	 * Date日期加上（负数减去）N秒
	 * @param date 原始日期
	 * @param second 正加负减
	 * @return 新的Date日期
	 */
	public static Date addSecond(Date date,int second){
		return add(date,Calendar.SECOND, second);
	} 

	/**
	 * Date日期加上（负数减去）N毫秒
	 * @param date 原始日期
	 * @param millisecond 正加负减
	 * @return 新的Date日期
	 */
	public static Date addMillisecond(Date date,int millisecond){
		return add(date,Calendar.MILLISECOND, millisecond);
	} 

	//-----------------------------------------------------------------------
	/**
	 * 获取指定日期当天的起始时间
	 * @param date 日期
	 * @return 指定日期当天00:00:00时间
	 */
	public static Date getStartTimeOfDay(Date date){
		Calendar calendar = Calendar.getInstance();	
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期当天的起始时间
	 * @param localDateTime 指定日期
	 * @return 当天00:00:00的时间
	 */
	public static LocalDateTime getStartTimeOfDay(LocalDateTime localDateTime){
		if(localDateTime==null){
			return null;
		}
		return LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(),
				localDateTime.getDayOfMonth(),0,0,0);
	}
	
	/**
	 * 根据年月日获取当天0点时间
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 指定年月日的00:00:00时间
	 */
	public static Date getStartTimeOfDay(int year,int month,int day){
		Calendar calendar = Calendar.getInstance();	
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期当天的结束时间
	 * @param date 日期
	 * @return 当天的23:59:59.999点日期
	 */
	public static Date getEndTimeOfDay(Date date){
		Calendar calendar = Calendar.getInstance();	
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期当天的结束时间
	 * @param localDateTime 指定日期
	 * @return 当天23:59:59.999的时间
	 */
	public static LocalDateTime getEndTimeOfDay(LocalDateTime localDateTime){
		if(localDateTime==null){
			return null;
		}
		return LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(),
				localDateTime.getDayOfMonth(),23, 59, 59,999*1000*1000);
	}
	
	/**
	 * 根据年月日获取当天结束时间
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 当天23:59:59.999点日期
	 */
	public static Date getEndTimeOfDay(int year,int month,int day){
		Calendar calendar = Calendar.getInstance();	
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期获取当月的第一天
	 * @param date 指定日期
	 * @return 当月1号00:00:00时间
	 */
	public static Date getStartTimeOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();	
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期获取当月的第一天
	 * @param localDateTime 指定日期
	 * @return 当月1号的00:00:00的时间
	 */
	public static LocalDateTime getStartTimeOfMonth(LocalDateTime localDateTime){
		if(localDateTime==null){
			return null;
		}
		LocalDate localDate2=LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), 1);
		return LocalDateTime.of(localDate2, LocalTime.of(0, 0, 0, 0));
	}

	/**
	 * 根据年月获取当月第一天时间
	 * @param year 年
	 * @param month 月
	 * @return 当月1号00:00:00时间
	 */
	public static Date getStartTimeOfMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();	
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 根据年月获取当月最后一天时间
	 * @param date 指定日期
	 * @return 当月最后一天23:59:59.999时间
	 */
	public static Date getEndTimeOfMonth(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期获取当月的最后一天
	 * @param localDateTime 指定日期
	 * @return 当月最后一天的29:59:59.999的时间
	 */
	public static LocalDateTime getEndTimeOfMonth(LocalDateTime localDateTime){
		if(localDateTime==null){
			return null;
		}
		LocalDate nextMonth=localDateTime.plusMonths(1).toLocalDate();
		LocalDate lastDay=LocalDate.of(nextMonth.getYear(), nextMonth.getMonthValue(), 1).minusDays(1);
		return LocalDateTime.of(lastDay, LocalTime.of(23, 59, 59, 999*1000*1000));
	}

	/**
	 * 根据年月获取当月最后一天时间
	 * @param year 年
	 * @param month 月
	 * @return 当月最后一天23:59:59.999时间
	 */
	public static Date getEndTimeOfMonth(int year,int month){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	
}