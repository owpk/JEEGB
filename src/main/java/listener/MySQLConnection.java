package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebListener
public class MySQLConnection implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(MySQLConnection.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("Context initialization: " + context.getContextPath());
        String jdbcConnectionString = context.getInitParameter("jdbcConnectionString").trim();
        String username = context.getInitParameter("dbUsername").trim();
        String password = context.getInitParameter("dbPassword").trim();
        if (isNotNullOrEmpty(jdbcConnectionString) || isNotNullOrEmpty(username)) {
            logger.error("Connection string and DB username must be specified");
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            context.setAttribute("jdbcConnection", connection);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println(username);
            System.out.println(password);
            System.out.println(jdbcConnectionString);
            logger.error(e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Connection conn = (Connection) context.getAttribute("jdbcConnection");
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            logger.error(e.getSQLState());
        }
    }

    private boolean isNotNullOrEmpty(String str) {
        return str != null && str.isEmpty();
    }
}
