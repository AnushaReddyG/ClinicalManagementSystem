package com.dop.cms.mail;


import java.io.File;
import java.io.IOException;
import java.util.Date;
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ipsit
 */

//email to user
public class Mailing {
	private static final String PROPERTIES_FILE="WebContent/emailTemplates/email_confirmation.vm";
	String d_email = "clinicalmanagementsystems@gmail.com",
			d_password="CS441_CMS",
			d_host = "smtp.gmail.com",
			d_port = "465", 
			m_to , m_subject, m_text;


	public boolean MailingHTML(String m_to,String m_subject,String m_text) {
		this.m_subject=m_subject;
		this.m_text=m_text;
		this.m_to=m_to;
		boolean status =false;

		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			//session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			
			
			
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent((new VelocityImpl()).getHtmlContent(), "text/html");
			mp.addBodyPart(htmlPart);
			
			//Attachment
/*			MimeBodyPart attachment = new MimeBodyPart();
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentData, "application/pdf");
			mp.addBodyPart(attachment);*/

			msg.setContent(mp);


			//			msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
			Transport.send(msg);
			status=true;
		} catch (Exception mex) {
			mex.printStackTrace();return status;
		}
		return status;
	}
	
	
	public boolean MailingHTML(String m_to,String m_subject,String m_text, String password) {
		this.m_subject=m_subject;
		this.m_text=m_text;
		this.m_to=m_to;
		boolean status =false;
		File file = new File(PROPERTIES_FILE);
		System.out.println(file.getAbsolutePath());
		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			//session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			
			
			
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			String content=null;
			if(m_text.equals("1")){
			content="<html><body><h3>Clinic Management System</h3><p><a href=\"\">My Account</a></p><legend>New Account Confirmation Mail ("+new Date().toString()+")</legend><p>This is a confirmation mail for new Account Creating :"+m_to+"  on "+new Date().toString()+"</p><p>Your password is "+password+"</p><span> Welcome to CMS </span></body></html>";
			}else{
				content="<html><body><h3>Clinic Management System</h3><p><a href=\"\">My Account</a></p><legend>Password Confirmation Mail ("+new Date().toString()+")</legend><p>This is a confirmation mail for change of password for account:"+m_to+"  on "+new Date().toString()+"</p><p>Your new password is "+password+"</p><span> Thank You for using CMS </span></body></html>";
			}
			htmlPart.setContent(content, "text/html");
			mp.addBodyPart(htmlPart);
			
			
			//Attachment
/*			MimeBodyPart attachment = new MimeBodyPart();
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentData, "application/pdf");
			mp.addBodyPart(attachment);*/

			msg.setContent(mp);


			//			msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
			Transport.send(msg);
			status=true;
		} catch (Exception mex) {
			mex.printStackTrace();return status;
		}
		return status;
	}
	

/*	//Testing method
	public boolean MailingHTML(String m_to,String m_subject,String m_text, String htmlBody, byte[] attachmentData) throws IOException {
		this.m_subject=m_subject;
		this.m_text=m_text;
		this.m_to=m_to;
		boolean status =false;

		Properties properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE));
//		properties.getProperty("mail.smtp.password", "CS441_CMS");
		
		properties.getProperty("mail.smtp.password");
		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(properties, auth);
			//session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);

			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent((new VelocityImpl()).getHtmlContent(), "text/html");
			mp.addBodyPart(htmlPart);
			
			//Attachment
			MimeBodyPart attachment = new MimeBodyPart();
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentData, "application/pdf");
			mp.addBodyPart(attachment);

			msg.setContent(mp);


			//			msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
			Transport.send(msg);
			status=true;
		} catch (Exception mex) {
			mex.printStackTrace();return status;
		}
		return status;
	}*/

// SMTP Authentication
	private class SMTPAuthenticator extends javax.mail.Authenticator {



		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(d_email, d_password);
		}
	}
	public static void main(String[] args) {


		//	   String m_to="varma_shravan@yahoo.com" ;
		//	   String m_to="agunta2@uic.edu" ;
		String m_to="ipsit.patra@gmail.com";
		String m_subject = "CMS-Statement";
		String m_text="Password Change Confirmation" ;

		Mailing mail=new Mailing();
//		String m_subject = "CMS-Statement";
//		String m_text="Appointment Confirmation" ;
		System.out.println(mail.MailingHTML(m_to, m_subject,m_text,"asim sucks"));
		
		
		File file = new File(PROPERTIES_FILE);
		System.out.println(file.getAbsolutePath());
		try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Mailing mail=new Mailing();
//		System.out.println(mail.MailingHTML(m_to, m_subject,m_text));
/*		try {
//			System.out.println(mail.MailingHTML(m_to, m_subject, m_text, null, null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	}

}
