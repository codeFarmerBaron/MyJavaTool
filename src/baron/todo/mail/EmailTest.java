package baron.todo.mail;


import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;

public class EmailTest {
	public void email(){
		System.out.println("测试邮件发送");
	}
	 private static String account = "peng.wang1@weifu.com.cn";
	    private static String pass = "1313Ljj";
	    private static String host = "mail.weifu.com.cn";
 
    public Boolean sendEmail(){
    	System.out.println("Sending!");
        ExchangeClient client = new ExchangeClient.ExchangeClientBuilder()
                .hostname(host)
                .exchangeVersion(ExchangeVersion.Exchange2010)
                .username(account)
                .password(pass)
                .recipientTo("发送邮箱地址")
                .subject("Test Subject")
                .message("Test Message")
                .build();
        client.sendExchange();

        System.out.println("Done!");
        return Boolean.TRUE;
    }
    
    public static void main(String[] args) {
    	EmailTest et=new EmailTest();
    	et.sendEmail();
	}
}
