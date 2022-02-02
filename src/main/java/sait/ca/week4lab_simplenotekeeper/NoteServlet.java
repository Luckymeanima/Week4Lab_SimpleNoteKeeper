/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sait.ca.week4lab_simplenotekeeper;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.ca.week4lab_simplenotekeeper.javabeans.Note;

/**
 *
 * @author Lucky
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/note"})
public class NoteServlet extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getQueryString();
        
        if (query != null && query.contains("edit")){
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            
        }else{
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = br.readLine();
        String contents = br.readLine();
        
        Note note = new Note(title, contents);
        
        request.setAttribute("note", note);
        
       getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        
 
    }
    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        
        String path = getServletContext().getRealPath("WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(title);
        pw.println(content);
        
        pw.close();
        
        response.sendRedirect("note");
    }
}
