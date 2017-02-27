package com.mycompany.empweb.job;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSendJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(MailSendJob.class);
	
	private boolean isRun = false;
	private static final String SEND_MAIL_ID = "xjrxjrtkftkf@gmail.com";
	private static final String SEND_MAIL_PW = "1095kimjh";
	private static final String SEND_STAMP_MAIL_ID = "smtp.gmail.com";
	
	private List<Map<String, Object>> employeeList;
	
	public MailSendJob() {}
	
	public MailSendJob (List<Map<String, Object>> employeeList) {
		this.employeeList = employeeList;
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		if (isRun) {
			return;
		}
		isRun = true;

		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", SEND_STAMP_MAIL_ID);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.quitwait", "false");
			
			Authenticator auth = new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(SEND_MAIL_ID, SEND_MAIL_PW);
				}
			};
			
			Session session = Session.getDefaultInstance(props,auth);
			
			MimeMessage message = new MimeMessage(session);
			message.setSender(new InternetAddress(SEND_MAIL_ID));
			message.setSubject("직원목록");
			
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("na46054@gmail.com"));
			
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			StringBuilder strMessage = new StringBuilder();
//			if (employeeList.isEmpty()) {
//				for (int i = 0; i < employeeList.size(); i++) {
//					Map<String, Object> employeeMap = employeeList.get(i);
//					strMessage.append("[ " + i + " ]");
//					strMessage.append("직원번호 : " + employeeMap.get("EMP_NO").toString());
//					strMessage.append("이름 : " + employeeMap.get("EMP_NAME").toString());
//					strMessage.append("전화번호 : " + employeeMap.get("EMP_PHONE").toString());
//					strMessage.append("직급 : " + employeeMap.get("EMP_POSITION").toString());
//					strMessage.append("이메일 주소 : " + employeeMap.get("EMP_EMAIL").toString());
//					strMessage.append("\n");
//				}
//			}
			
			//test message
			strMessage.append("테스트 내용");
			
			mbp1.setText(strMessage.toString());
			mp.addBodyPart(mbp1);
			
			message.setContent(mp);
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isRun = false;
		}
	}

	public static void main(String[] args) {
		MailSendJob job = new MailSendJob();
		try {
			job.execute(null);
		} catch (JobExecutionException e) {
			e.printStackTrace();
		}
	}

}
