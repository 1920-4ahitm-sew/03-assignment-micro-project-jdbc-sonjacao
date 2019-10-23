package at.htl.library.servlet;

import at.htl.library.database.Database;
import at.htl.library.model.PublishingHouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("libservlet")
public class LibraryServlet extends HttpServlet {

    static Database db = new Database();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        resp.setContentType("text/html");
        output.println("<html>");
        output.println("<head>" +
                "<title>Publishing Houses</title>" +
                "<meta charset='UTF-8'>");
        output.println("<style>" +
                "* {margin:0; padding:0; font-family:Arial}" +
                "table{width:100%;text-align:center;}" +
                "</style>");
        output.println("</head>");
        output.println("<body>");
        output.println("<h1>Publishing Houses</h1>");
        output.println("<table>");
        output.println("<tr>" +
                "<th>Publisher No.</th>" +
                "<th>Publisher Name</th>" +
                "<th>Street</th>" +
                "<th>Postal Code</th>" +
                "<th>City</th>" +
                "<th>Country</th>" +
                "</tr>");

        List<PublishingHouse> publishingHouseList = db.selectAllPublishingHouses();
        for (PublishingHouse ph : publishingHouseList) {
            output.println("<tr>" +
                    "<td>" + ph.getPublisherNo() + "</td>" +
                    "<td>" + ph.getPublisherName() + "</td>" +
                    "<td>" + ph.getStreet() + "</td>" +
                    "<td>" + ph.getPostalCode() + "</td>" +
                    "<td>" + ph.getCity() + "</td>" +
                    "<td>" + ph.getCountry() + "</td>" +
                    "</tr>");
        }

        output.println("</table>");
        output.println("</body></html>");
    }
}
