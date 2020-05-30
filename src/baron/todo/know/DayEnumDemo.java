package baron.todo.know;

/**
 * 枚举（enum）类型是Java 5新增的特性。<br>
 * 它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。<br>
 * 所有的枚举都继承自java.lang.Enum类。<br>
 * 由于Java 不支持多继承，所以枚举对象不能再继承其他类（可以实现接口）。<br>
 * @author peng.wang1
 *
 */
enum Day{

	//相当于调用构造方法
	MONDAY("星期一",1),THUSDAY("星期二",2);//这个后面必须有分号

	private String name ;
	private int index ;

	private Day( String name , int index ){
		this.name = name ;
		this.index = index ;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}

public class DayEnumDemo {

	public static void main(String[] args) {
		//输出某一枚举的值
		System.out.println( "Day.MONDAY:"+Day.MONDAY );
		System.out.println( "name:"+Day.MONDAY.getName() );
		System.out.println( "index:"+Day.THUSDAY.getIndex() );
		System.out.println( "*********************************");

		//遍历所有的枚举
		for( Day color : Day.values()){
			System.out.println( color + "  name: " + color.getName() + "  index: " + color.getIndex() );
		}
	}

}


