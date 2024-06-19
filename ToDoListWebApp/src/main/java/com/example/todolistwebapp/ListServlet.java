/*
    Mark Fowler
    CEN-4025C-24672
    3/24/24

    The ListServlet Class communicates information between the index jsp page and the List Class.
 */
package com.example.todolistwebapp;

import java.io.*;
import java.util.ArrayList;
import entity.List;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "showList", value = "/show-list")
public class ListServlet extends HttpServlet {

    /*
        doGet()
        Purpose: Receives user input to call the GetList method then writes to the web page with results.
        Return Type: N/A
        Arguments: A HttpServletRequest and HttpServletResponse
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List list = new List();
        ArrayList<String> listOfTasks = list.GetList();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Your To Do List: </h1>");
        out.println("<p>");

        int num = 1;
        for(String i: listOfTasks) {
            out.println("Task " + num + ": " + i + "<br>");
            num++;
        }

        out.println("</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
