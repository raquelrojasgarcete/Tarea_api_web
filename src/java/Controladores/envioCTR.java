/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raquel
 */
@WebServlet("/localhost:8080/api/envios")
public class envioCTR extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        String CODIGOCLIENTE = request.getParameter("CODIGOCLIENTE");
        String NOMBRECLIENTE = request.getParameter("NOMBRECLIENTE");
        String FECHAPEDIDO = request.getParameter("FECHAPEDIDO");
        String FECHAENTREGA = request.getParameter("FECHAENTREGA");
        String VENDEDOR = request.getParameter("VENDEDOR");
        String MONEDA = request.getParameter("MONEDA");
        String CODIGOARTICULO = request.getParameter("CODIGOARTICULO");
        String DESCRIPCIONARTICULO = request.getParameter("DESCRIPCIONARTICULO");
        String CANTIDAD = request.getParameter("CANTIDAD");
        String UNITARIO = request.getParameter("UNITARIO");
        
        int total=0;
        total=Integer.parseInt(CANTIDAD)*Integer.parseInt(UNITARIO);

        Date myDate = new Date();
        String sysdate = new SimpleDateFormat("yyyy-MM-dd").format(myDate);

        if (FECHAPEDIDO.equals(sysdate)) {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>RESULTADO</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Pedido enviado</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            String REST_JSON = "{\n"
                    + "         \"ID\":" + id + ",\n"
                    + "         \"CIENTE\":" + CODIGOCLIENTE + ",\n"
                    + "         \"NOMBRE\":\"" + NOMBRECLIENTE + "\",\n"
                    + "         \"FECHA\":\"" + FECHAPEDIDO + "\",\n"
                    + "         \"FECHAENTREGA\":\"" + FECHAENTREGA + "\",\n"
                    + "         \"VENDEDOR\":\"" + VENDEDOR + "\",\n"
                    + "         \"MONEDA\":\"" + MONEDA + "\",\n"
                    + "         \"ARTICULO\":" + CODIGOARTICULO + ",\n"
                    + "         \"DESARTICULO\":\"" + DESCRIPCIONARTICULO + "\",\n"
                    + "         \"CANTIDAD\":" + CANTIDAD + ",\n"
                    + "         \"UNITARIO\":" + UNITARIO + ",\n"
                    + "         \"TOTAL\":" + total + "\n"
                    + "     }";
            System.out.println("formato json: " + REST_JSON);


            String json = new Gson().toJson(REST_JSON);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>RESULTADO</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>La fecha no puede ser menor o mayor a la fecha actual</h1>");
                out.println("</body>");
                out.println("</html>");

            }

        }

        System.out.println("id de ped " + id);

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
