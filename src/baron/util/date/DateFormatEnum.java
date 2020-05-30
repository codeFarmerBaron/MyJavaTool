package baron.util.date;

/**
 * 时间格式字符串枚举。
 * @author Baron
 * @version 0.0.1
 * @since java8
 * @time 2020/5/30
 *
 */
public enum DateFormatEnum {

	/**
	 * 日期格式 ，只有日期，年月日数字堆叠，yyyyMMdd
	 */
	DATE("yyyyMMdd",1),
	/**
	 * 日期格式 ，只有日期，英文短横杠连接，yyyy-MM-dd
	 */
	DATE_EN("yyyy-MM-dd",2),
	/**
	 * 日期格式 ，只有日期，中文年月日连接，yyyy年MM月dd日
	 */
	DATE_CN("yyyy年MM月dd日",3),
	/**
	 * 日期格式 ，日期和时间（24小时制），年月日时分秒数字堆叠，yyyyMMddHHmmss
	 */
	DATE_TIME("yyyyMMddHHmmss",4),

	/**
	 * 日期格式 ，日期和时间（24小时制），日期英文短横杠、时间英文冒号连接，yyyy-MM-dd HH:mm:ss
	 */
	DATE_TIME_EN("yyyy-MM-dd HH:mm:ss",5),
	/**
	 * 日期格式 ，日期和时间（24小时制），中文年月日时分秒连接，yyyy年MM月dd日 HH时mm分ss秒
	 */
	DATE_TIME_CN("yyyy年MM月dd日 HH时mm分ss秒",6),
	/**
	 * 日期格式 ，只有时间（24小时制），时分秒数字堆叠，HHmmss
	 */
	TIME("HHmmss",7),
	/**
	 * 日期格式 ，只有时间（24小时制），时分秒数字冒号连接，HH:mm:ss
	 */
	TIME_EN("HH:mm:ss",8),
	/**
	 * 日期格式 ，日期和时间（24小时制），LocalDateTime的默认格式，yyyy-MM-dd'T'HH:mm:ss.SSS
	 */
	LOCALDATETIME_DEFAULT("yyyy-MM-dd'T'HH:mm:ss.SSS",9),
	/**
	 * 日期格式 ，日期和时间（24小时制），Date的默认格式，EEE MMM dd HH:mm:ss zzz yyyy
	 */
	DATE_DEFAULT("EEE MMM dd HH:mm:ss zzz yyyy",10),
	/**
	 * 日期格式 ，日期和时间（24小时制），Date的默认格式，EEE MMM dd HH:mm:ss zzz yyyy
	 */
	DATE_DEFAULT_US("EEE MMM dd HH:mm:ss zzz yyyy",11);

	private String content="";
	private int index=0;

	private DateFormatEnum(String content,int index){
		this.content=content;
		this.index=index;
	}

	public String getContent() {
		return content;
	}

	public int getIndex() {
		return index;
	}

}
