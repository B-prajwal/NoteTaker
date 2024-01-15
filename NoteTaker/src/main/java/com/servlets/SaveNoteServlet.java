package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try{
			//title,content,fetch
			String title = request.getParameter("title");
			String content = request.getParameter("content"); 
			
			//creating an object of note class
			Note note = new Note(title, content, new Date());
			//System.out.println(note.getId()+" : "+note.getTitle());
			
			
			//HiberNate:save( )
			//calling a method from FactoryProvider class and using getfactory also opening a session
			Session s = FactoryProvider.getfactory().openSession();
			//to put this data permanently in databases for that open a transaction
			Transaction tx = s.beginTransaction();
			s.save(note);
			
			
			//after saving the object to save in database commit the transaction
			tx.commit();
			
			//closing session
			s.close();
			//Browser can resolve the data that its in text form for that
			response.setContentType("text/html");
			//after adding the data and give the msg that data added successfully
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added successfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a></h1>");
			
		}
		catch(Exception e){
			e.printStackTrace(); //error will get on console
		}
		
	}

}
