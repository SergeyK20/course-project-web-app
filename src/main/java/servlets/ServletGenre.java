package servlets;

import service.Service;
import service.ServiceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/genre")
public class ServletGenre extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Service service = ServiceUtils.commandDefinition(req.getParameter("command"), "GET_GENRE");
            String path = service.execute(req, resp);
            req.getRequestDispatcher(path).forward(req, resp);
        } catch (NullPointerException e) {
            req.setAttribute("error", "На сервер пришло пустое значение...");
            req.getRequestDispatcher("jsp/error/error500.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("jsp/error/error500.jsp").forward(req, resp);
        }
    }
}
