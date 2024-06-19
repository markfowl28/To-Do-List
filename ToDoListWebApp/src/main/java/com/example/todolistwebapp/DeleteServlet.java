/*
    Mark Fowler
    CEN-4025C-24672
    3/24/24

    The  DeleteServlet Class communicates information between the delete jsp page and the Delete Class.
 */
package com.example.todolistwebapp;

import entity.Delete;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteFromList", value = "/DeleteFromList")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    /*
        doPost()
        Purpose: Receives user input to call the DeleteEntry method then writes to the web page with results.
        Return Type: N/A
        Arguments: A HttpServletRequest and HttpServletResponse
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String entry = request.getParameter("entry");
        Delete delete = new Delete();
        boolean noResult = delete.DeleteEntry(entry);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (noResult) {
            out.print("<html><body>");
            out.print("<h1>Error!</h1>");
            out.println("<p>" + entry + " is not on the to do list </p>");
            out.print("</body></html>");
        } else {
            out.print("<html><body>");
            out.print("<h1>Success!</h1>");
            out.println("<p>" + entry + " has been removed from your tasks </p>");
            out.print("</body></html>");
        }

    }

    public void destroy() {
    }
}
