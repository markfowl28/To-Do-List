/*
    Mark Fowler
    CEN-4025C-24672
    3/24/24

    The AddServlet Class communicates information between the add jsp page and the Add Class.
 */
package com.example.todolistwebapp;

import entity.Add;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToList", value = "/AddToList")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddServlet() {
        super();
    }

    /*
        doPost()
        Purpose: Receives user input to call the AddEntry method then writes to the web page with results.
        Return Type: N/A
        Arguments: A HttpServletRequest and HttpServletResponse
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String entry = request.getParameter("entry");
        Add add = new Add();
        add.AddEntry(entry);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("<h1>Success!</h1>");
        out.println("<p>" + entry + " has been added to your tasks </p>");
        out.print("</body></html>");
    }

    public void destroy() {
    }
}
