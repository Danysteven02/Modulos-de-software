
package proyecto.peluqueria;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Datos de conexión
        String usuarioDB ="root";
        String passwordDB ="";
        String url ="jdbc:mysql://localhost:3306/peluqueria";
        
        //Obtener datos del formulario
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        //obtejos de conexión y consulta
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuarioDB, passwordDB);
            
            String query = "SELECT * FROM usuario WHERE usuario=? and contrasena=?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                request.setAttribute("usuario", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("panel.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("mensajeError", "Usuario o Contraseña Incorrecta");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensajeError", "Error al Conectar con la Base de Datos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } finally{
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
                }
                
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
