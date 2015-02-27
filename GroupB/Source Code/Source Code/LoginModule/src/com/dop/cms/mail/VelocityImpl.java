package com.dop.cms.mail;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

// implementing velocity
public class VelocityImpl {

	private String htmlContent;


	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}



	/**
	 * @param htmlContent the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}


	public VelocityImpl(){
		
	}
	
	
	public VelocityImpl(String username) throws Exception {

		VelocityEngine ve = new VelocityEngine();
		ve.init();

		/*
		 *   organize our data 
		 */
		Date d=new Date();
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", username);
		map.put("timeCurrent", d.toString());
		map.put("date", "10 Oct 2014");
		map.put("time", "10:15 am");
		map.put("password", "10:15 am");

		/*
		 *  add that list to a VelocityContext
		 */

		VelocityContext context = new VelocityContext();
		context.put("map", map);

		
		/*
		 *   get the Template  
		 */
		// TODO Include the logic and the database querying 
		//	        Template t = ve.getTemplate( "./WebContent/emailTemplates/email_html.vm" );
		Template t = ve.getTemplate( "./WebContent/emailTemplates/email_confirmation.vm" );

		/*
		 *  now render the template into a Writer, here 
		 *  a StringWriter 
		 */

		StringWriter writer = new StringWriter();

		t.merge( context, writer );

		/*
		 *  use the output in the body of your emails
		 */

		System.out.println( writer.toString() );
		htmlContent = writer.toString();


	}


	public VelocityImpl(String username, String password) throws Exception {

		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty("resource.loader", "class");
//		ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		ve.init();
		/*
		 *   organizing data 
		 */
		Date d=new Date();
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", username);
		map.put("timeCurrent", d.toString());
		map.put("date", new Date().toString());
		map.put("time", "<Time>");// to be coded
		map.put("password", password);

		/*
		 *  add that list to a VelocityContext
		 */

		VelocityContext context = new VelocityContext();
		context.put("map", map);

		/*
		 *   get the Template  
		 */
		
		Template t = ve.getTemplate( "./WebContent/WEB-INF/emailTemplates/email_password.vm" );

		/*
		 *  now render the template into a Writer, here 
		 *  a StringWriter 
		 */

		StringWriter writer = new StringWriter();

		t.merge( context, writer );

		/*
		 *  use the output in the body of your emails
		 */

		System.out.println( writer.toString() );
		htmlContent = writer.toString();


	}
}
