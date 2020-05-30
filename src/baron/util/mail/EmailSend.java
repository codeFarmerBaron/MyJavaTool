package baron.util.mail;


import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;

public class EmailSend {

	private String host;
	private String account;
	private String pass;

	public EmailSend(String host,String account,String pass){
		this.host=host;
		this.account=account;
		this.pass=pass;
	}
	
	public Boolean sendEmail(String receiver,String subject,String content){
		ExchangeEmail client = new ExchangeEmail.ExchangeClientBuilder()
				.hostname(host)
				.exchangeVersion(ExchangeVersion.Exchange2010)
				.username(account)
				.password(pass)
				.recipientTo(receiver)
				.subject(subject)
				.message(content)
				.build();
		client.sendExchange();
		return Boolean.TRUE;
	}

}
