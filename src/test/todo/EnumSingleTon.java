package test.todo;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName EnumSingleTon
 * @Description TODO
 * @Author Chongwen.jiang
 * @Date 2020/5/10 11:17
 * @ModifyDate 2020/5/10 11:17
 * @Version 1.0
 */
public enum EnumSingleTon implements Serializable {
    INSTANCE;
    EnumSingleTon(){}

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
    	EnumSingleTon s = EnumSingleTon.INSTANCE;
    	        s.setContent("枚举单例序列化");
    	       System.out.println("枚举序列化前读取其中的内容："+s.getContent());
    	         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
    	         oos.writeObject(s);
    	         oos.flush();
            oos.close();
     
    	         FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
    	         ObjectInputStream ois = new ObjectInputStream(fis);
    	         EnumSingleTon s1 = (EnumSingleTon)ois.readObject();
    	        ois.close();
    	        System.out.println(s+"\n"+s1);
    	         System.out.println("枚举序列化后读取其中的内容："+s1.getContent());
    	         System.out.println("枚举序列化前后两个是否同一个："+(s==s1));

        /*ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("EnumSingleTon.obj"));
        os.writeObject(s1);
        os.flush();
        os.close();

        FileInputStream is = new FileInputStream("EnumSingleTon.obj");
        ObjectInputStream oss = new ObjectInputStream(is);
        EnumSingleTon s4 = (EnumSingleTon)oss.readObject();
        oss.close();
        is.close();
        System.out.println(s4.getContent());
        System.out.println(s1 == s4);*/
    }
}
