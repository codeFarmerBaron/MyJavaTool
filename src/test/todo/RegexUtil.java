package test.todo;


/**
 * 常用正则表达式；
 * 匹配规则详情见 Pattern 类。
 * @author Baron
 *
 */
public final class RegexUtil {
	/**
	 * 
	 * <p>英文的句号    . </p>
	 * <p>可以匹配任意单个字符，但不会匹配换行符和新行的字符</p>
	 * <ul>
	 * <li>".th" 表示： 任意字符后面跟着一个字母 t， 再后面跟着一个字母 h；</li>
	 * <li>".th" 匹配：  ath、1th 等 ；</li>
	 * <li>".th" 不配：  th、the  等 。</li>
	 * </ul>
	 */
	public static final String CHAR_ANY=".";

	/**
	 * <p>英文的方括号 [] </p>
	 * <p>匹配方括号中包含的任意字符；</p>
	 * <ul>
	 * <li>"[th]e" 表示： 字母t或者字母h，后面跟着一个字母 e；</li>
	 * <li>"[th]e" 匹配：  te、he ；</li>
	 * <li>"[th]e" 不配：  the  等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[a-z]e" 表示： 字母a直到字母z中的任意一个字母（任意一个小写字母），后面跟着一个字母 e；</li>
	 * <li>"[a-z]e" 匹配：  ae、fe 等 ；</li>
	 * <li>"[a-z]e" 不配：Te、e、aef  等 。</li>
	 * </ul>
	 */
	public static final String CHAR_IN_THIS_L="[";

	/**
	 * <p>英文的方括号 [] </p>
	 * <p>匹配方括号中包含的任意字符；</p>
	 * <ul>
	 * <li>"[th]e" 表示： 字母t或者字母h，后面跟着一个字母 e；</li>
	 * <li>"[th]e" 匹配：  te、he ；</li>
	 * <li>"[th]e" 不配：  the  等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[a-z]e" 表示： 字母a直到字母z中的任意一个字母（任意一个小写字母），后面跟着一个字母 e；</li>
	 * <li>"[a-z]e" 匹配：  ae、fe 等 ；</li>
	 * <li>"[a-z]e" 不配：Te、e、aef  等 。</li>
	 * </ul>
	 */
	public static final String CHAR_IN_THIS_R="]";

	/**
	 * <p>英文状态shift+6 ^ </p>
	 * <p>在方括号内时，匹配方括号中不包含的任意字符，只能匹配一个字符；</p>
	 * <ul>
	 * <li>"[^abc]" 表示：除a、b、c三个字母之外的任意一个字符；</li>
	 * <li>"[^abc]" 匹配：e 、 # 、1 等 ；</li>
	 * <li>"[^abc]" 不配：a、b、c、af、ef 等。</li>
	 * </ul>
	 */
	public static final String CHAR_NOT_IN_THIS="^";

	/**
	 * <p>乘号 * </p>
	 * <p>匹配前面的子表达式零次或多次；</p>
	 * <ul>
	 * <li>"th*" 表示：字母t，后边跟着0个或多个字母h；</li>
	 * <li>"th*" 匹配：t、th、thhh 等 ；</li>
	 * <li>"th*" 不配：the、thth 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[abc]*" 表示：空字符，或者后边再跟字母a、b、c中的任意一个，或者后边再跟字母a、b、c中的任意一个，...；</li>
	 * <li>"[abc]*" 匹配：空字符、b、ac、bac、abca 等 ；</li>
	 * <li>"[abc]*" 不配：d、ad 等 。</li>
	 * </ul>
	 */
	public static final String CHAR_ZERO_OR_MULTI="*";

	/**
	 * <p>加号 + </p>
	 * <p>匹配前面的子表达式一次或多次；</p>
	 * <ul>
	 * <li>"th+" 表示：字母t，后边跟着1个或多个字母h；</li>
	 * <li>"th+" 匹配：th、thhh 等 ；</li>
	 * <li>"th+" 不配：t、thhh、the 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]+" 表示：字母t、h中的任意一个，（至此必要后边可选），或者后边再跟字母t、h中的任意一个，...；</li>
	 * <li>"[th]+" 匹配：t、th、httt 等 ；</li>
	 * <li>"[th]+" 不配：空字符、d、ad 等 。</li>
	 * </ul>
	 */
	public static final String CHAR_ONE_OR_MULTI="+";

	/**
	 * <p>英文问号 ? </p>
	 * <p>匹配前面的子表达式零次或一次，或指明一个非贪婪限定符；</p>
	 * <ul>
	 * <li>"th?" 表示：字母t，后边跟着0个1个字母h；</li>
	 * <li>"th?" 匹配：t、th ；</li>
	 * <li>"th?" 不配：thhh、the 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]?" 表示：空字符，或者后边再跟字母t、h中的任意一个；</li>
	 * <li>"[th]?" 匹配：空字符、t、h ；</li>
	 * <li>"[th]?" 不配：hh、tht 等 。</li>
	 * </ul>
	 */
	public static final String CHAR_ZERO_OR_ONE="?";

	/**
	 * <p>英文花括号 {}  </p>
	 * <p>{n,m}匹配前面字符至少 n 次，但是不超过 m 次；</p>
	 * <ul>
	 * <li>"th{1,3}" 表示：字母t，后边跟着1~3个字母h；</li>
	 * <li>"th{1,3}" 匹配：th、thh、thhh ；</li>
	 * <li>"th{1,3}" 不配：thhh、the 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]{2,}" 表示：字母t、h中的任意一个，后边跟字母t、h中的任意一个（至此必要后边可选），或者后边再再跟母t、h中的任意一个，...；</li>
	 * <li>"[th]{2,}" 匹配：t、h、th、hhh等 ；</li>
	 * <li>"[th]{2,}" 不配：空字符、he 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]{2}" 表示：字母t、h中的任意一个，后边跟字母t、h中的任意一个；</li>
	 * <li>"[th]{2}" 匹配：th、ht、hh、tt ；</li>
	 * <li>"[th]{2}" 不配：t、thh、the 等 。</li>
	 * </ul>
	 */
	public static final String HOW_MANY_L="{";

	/**
	 * <p>英文花括号 {} </p>
	 * <p>{n,m}匹配前面字符至少 n 次，但是不超过 m 次；</p>
	 * <ul>
	 * <li>"th{1,3}" 表示：字母t，后边跟着1~3个字母h；</li>
	 * <li>"th{1,3}" 匹配：th、thh、thhh ；</li>
	 * <li>"th{1,3}" 不配：thhh、the 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]{2,}" 表示：字母t、h中的任意一个，后边跟字母t、h中的任意一个（至此必要后边可选），或者后边再再跟母t、h中的任意一个，...；</li>
	 * <li>"[th]{2,}" 匹配：t、h、th、hhh等 ；</li>
	 * <li>"[th]{2,}" 不配：空字符、he 等 。</li>
	 * </ul>
	 * <ul>
	 * <li>"[th]{2}" 表示：字母t、h中的任意一个，后边跟字母t、h中的任意一个；</li>
	 * <li>"[th]{2}" 匹配：th、ht、hh、tt ；</li>
	 * <li>"[th]{2}" 不配：t、thh、the 等 。</li>
	 * </ul>
	 */
	public static final String HOW_MANY_R="}";

	/**
	 * <p>英文括号 () </p>
	 * <p>字符组，(abc)按照确切的顺序匹配字符abc；</p>
	 * <ul>
	 * <li>"(bac)" 表示：字母b，后边跟着字母a，后边跟着字母c；</li>
	 * <li>"(bac)" 匹配：bac ；</li>
	 * <li>"(bac)" 不配：除了bac以外的所有字符串 。</li>
	 * </ul>
	 */
	public static final String CHAR_GROUP_L="(";

	/**
	 * <p>英文括号 () </p>
	 * <p>字符组，(abc)按照确切的顺序匹配字符abc；</p>
	 * <ul>
	 * <li>"(bac)" 表示：字母b，后边跟着字母a，后边跟着字母c；</li>
	 * <li>"(bac)" 匹配：bac ；</li>
	 * <li>"(bac)" 不配：除了bac以外的所有字符串 。</li>
	 * </ul>
	 */
	public static final String CHAR_GROUP_R=")";

	/**
	 * <p>英文竖线 | </p>
	 * <p>分支结构，匹配符号之前的字符或后面的字符；</p>
	 * <ul>
	 * <li>"a|bc" 表示：字母a，或者字符串bc；</li>
	 * <li>"a|bc" 匹配：a、bc ；</li>
	 * <li>"a|bc" 不配：除了a和bc以外的所有字符串 。</li>
	 * </ul>
	 * <ul>
	 * <p>有点像‘或’，|前、后的字符串默认带括号，但只在[]内时默认不带括号</p>
	 * <li>"ab|dc" 等价于 "(ab)|(dc)"；</li>
	 * <li>"[ab|dc]" 等价于 [abdc]；</li>
	 * </ul>
	 */
	public static final String OR="|";
	
	public static final String AND="&";

	/**
	 * <p>英文斜线 \ </p>
	 * <p>转义符，它可以还原元字符原来的含义，允许你匹配保留字符；</p>
	 * <ul>
	 * <li>"\." 表示：字符 . ；</li>
	 * <li>"\." 匹配：. ；</li>
	 * </ul>
	 */
	public static final String TRANSFER="\\";

	/**
	 * <p>英文状态shift+6 ^ </p>
	 * <p>匹配行的开始；</p>
	 */
	//todo
	public static final String BEGIN="^";

	/**
	 * <p>美元符号 $ </p>
	 * <p>匹配行的结束；</p>
	 */
	//todo
	public static final String END="$";

	//	简写字符集

	/**
	 * <p>\w </p>
	 * <p>斜线和小写字母w：</p>
	 * <p>匹配所有字母和数字的任一字符: [a-zA-Z0-9]</p>
	 */
	public static final String LETTER_NUMBER="\\w";

	/**
	 * <p>\W </p>
	 * <p>斜线和大写字母w：</p>
	 * <p>匹配非字母和数字的任一字符: [^\w]或[^a-zA-Z0-9]</p>
	 */
	public static final String LETTER_NUMBER_NON="\\W";

	/**
	 * <p>\d </p>
	 * <p>斜线和小写字母d：</p>
	 * <p>匹配任一数字: [0-9]</p>
	 */
	public static final String NUMBER="\\d";

	/**
	 * <p>\D </p>
	 * <p>斜线和大写字母d：</p>
	 * <p>匹配任一非数字: [^\d]或[^0-9]</p>
	 */
	public static final String NUMBER_NON="\\D";

	/**
	 * <p>\s </p>
	 * <p>斜线和小写字母s：</p>
	 * <p>匹配空格符: [\t\n\f\r\p{Z}]</p>
	 */
	public static final String BLANK="\\s";

	/**
	 * <p>\S </p>
	 * <p>斜线和大写字母S：</p>
	 * <p>匹配非空格符: ^\s]或[^\t\n\f\r\p{Z}]</p>
	 */
	public static final String BLANK_NON="\\S";

	//常用正则表达式
	
	/**
	 * <p>整数</p>
	 */
	public static final String INTRGER = "^-?\\d+$";
	
	/**
	 * <p>自然数</p>
	 * <p>正整数和0</p>
	 */
	public static final String INTEGER_NATURAL = "^\\d+$";
	
	/**
	 * <p>正整数</p>
	 */
	public static final String INTEGER_POSITIVE = "^[1-9]\\d*$";

	
	/**
	 * <p>负整数</p>
	 */
	public static final String INTEGER_NEGATIVE = "^-[1-9]\\d*$";
	
	/**
	 * <p>正浮点数</p>
	 */
	public static final String FLOAT_POSITIVE = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
	
	/**
	 * <p>负数浮点数</p>
	 */
	public static final String FLOAT_NEGATIVE = "^-[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";

	/**
	 * <p>手机号，如13912345678</p>
	 */
	public static final String PHONE_MOBILE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	
	/**
	 * <p>电话号，如0510-12345678</p>
	 */
	public static final String PHONE_TEL = "^(\\d{3,4}-)?\\d{7,8}$";
	private RegexUtil(){
	}


}
