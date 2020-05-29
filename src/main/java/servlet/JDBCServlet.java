package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.OptionalInt;

@WebServlet(name = "JdbcServlet", urlPatterns = "/sql")
public class JDBCServlet extends HttpServlet {

    private Connection conn;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        conn = (Connection) context.getAttribute("jdbcConnection");

        if (conn == null) {
            throw new ServletException("No JDBC connection in Servlet Context");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sys.sys_config;");
            int columns = rs.getMetaData().getColumnCount();
            ArrayList<String>[] res = new ArrayList[columns];
            for (int i = 0; i < res.length; i++) {
                res[i] = new ArrayList<>();
            }

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    res[i-1].add(rs.getString(i));
                }
            }

            for (ArrayList<String> re : res) {
                OptionalInt opt = re.stream().filter(Objects::nonNull).mapToInt(String::length).max();
                int length = opt.isPresent() ? opt.getAsInt() : "null".length();
                if (opt.isPresent()) {
                    for (int i = 0; i < re.size(); i++) {
                        StringBuilder space = new StringBuilder("  ");
                        if (re.get(i) != null) {
                            for (int k = 0; k < length - re.get(i).length(); k++) {
                                space.append(" ");
                            }
                            re.set(i, re.get(i) + space);
                        } else {
                            for (int j = 0; j < length - "null".length() ; j++)
                                space.append(" ");
                            re.set(i, "    " + space);
                        }
                    }
                }
            }

            int colInd = 0;
            for (int i = 0; i < res[colInd++].size(); i++) {
                if (colInd == columns)
                    colInd = 0;
                for (ArrayList<String> re : res) {
                    resp.getWriter().write("<br>|" + re.get(i));
                }
                resp.getWriter().write("|</br>");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
