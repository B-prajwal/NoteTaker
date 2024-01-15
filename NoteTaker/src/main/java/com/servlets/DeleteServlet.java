package com.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			//to delete the notes 
			//.trim if there any space in between words that also be going to cut
			int noteId =  Integer.parseInt(request.getParameter("note_id").trim());
			
			//Opening session 
			Session s = FactoryProvider.getfactory().openSession();
			Transaction tx = s.beginTransaction();
			//save the note id in note variable
			Note note =(Note)s.get(Note.class,noteId); 	
			
			
			//it will delete the note
			s.delete(note);	
			
			
			//for physical changes in the database
			tx.commit();
			
			//closing the session
			s.close();
			
			//send again user to the show notes page
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	

}
