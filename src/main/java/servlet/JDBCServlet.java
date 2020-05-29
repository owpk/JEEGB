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
import java.util.Arrays;
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

            //print table ->
            int colInd;
            boolean flag = true;
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    if (flag)
                        res[i-1].add(rs.getMetaData().getColumnLabel(i));
                    else
                        res[i-1].add(rs.getString(i));
                }
                flag = false;
            }

            resp.getWriter().write("<table border=\"1\">");
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

            colInd = 0;
            boolean canWrite;
            String[] lines = new String[columns];
            int ind = 0;

            for (ArrayList<String> strings : res) {
                StringBuilder line = new StringBuilder("+");
                for (int j = 0; j < strings.get(0).length(); j++)
                    line.append("-");
                lines[ind] = line.toString();
                if (ind == lines.length - 1)
                    lines[ind] = lines[ind].concat("+");
                ind++;
            }

            int row = 0;
            for (int i = 0; i < res[colInd].size(); i++) {
                if (colInd == columns - 1)
                    colInd = 0;
                canWrite = row == 1 || row == 0;
                row++;
                if(canWrite) {
                    Arrays.stream(lines).forEach(System.out::print);
                    System.out.println("");
                }
                resp.getWriter().write("<tr>");
                for (ArrayList<String> re : res) {
                    resp.getWriter().write("<td>" + re.get(i)+ "<td>");
                    System.out.print("|" + re.get(i));
                }
                colInd++;
                resp.getWriter().write("</tr>");
                System.out.println("|");
            }
            resp.getWriter().write("</table>");
            Arrays.stream(lines).forEach(System.out::print);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
