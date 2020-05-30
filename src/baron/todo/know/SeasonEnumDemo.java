package baron.todo.know;

/**
 * 枚举（enum）类型是Java 5新增的特性。<br>
 * 它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。<br>
 * 所有的枚举都继承自java.lang.Enum类。<br>
 * 由于Java 不支持多继承，所以枚举对象不能再继承其他类（可以实现接口）。<br>
 * @author peng.wang1
 *
 */
interface SeasonInterface {
	public String getSeason();
}
enum Season implements SeasonInterface{

	MONDAY(1,"星期一"),THUSDAY(2,"星期二");//这个后面必须有分号

	private int code;
	private String name;
	private Season(int code,String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.getName()+"---"+this.getCode();
	}

	@Override
	public String getSeason() {
		return this.getName();
	}
}

public class SeasonEnumDemo {
	
	public static void main(String[] args) {
		System.out.println(Season.THUSDAY.getSeason());
	}
	 
}




