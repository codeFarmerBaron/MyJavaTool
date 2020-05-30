package baron.todo.know;

/**
 * 枚举（enum）类型是Java 5新增的特性。<br>
 * 它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。<br>
 * 所有的枚举都继承自java.lang.Enum类。<br>
 * 由于Java 不支持多继承，所以枚举对象不能再继承其他类（可以实现接口）。<br>
 * @author peng.wang1
 */

enum Color {
	RED, GREEN, BLANK, YELLOW 
}

public class ColorEnumDemo {

	public static void main(String[] args) {
		showColor( Color.RED );
		System.out.println("color:"+Color.RED);
	}

	private static void showColor(Color color){
		switch ( color ) {
		case BLANK:
			System.out.println( color );
			break;
		case RED :
			System.out.println( color );
			break;
		default:
			System.out.println( color );
			break;
		}
	}

}

