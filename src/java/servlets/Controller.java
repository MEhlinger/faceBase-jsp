package servlets;

import datastore.DAOSQLite;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Face;

/**
 * All of this application's web pages send their requests to this controller
 * which then updates the model / database as needed and transfers control with
 * data to one the the HTML/JSP view-oriented programs for display.
 *
 * @author John Phillips
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get real path to the sqlite db
        ServletContext sc = this.getServletContext();
        String dbPath = sc.getRealPath("/WEB-INF/employee.db");

        // set default url
        String url = "/home.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "home";
        }

        // perform action and set url
        if (action.equalsIgnoreCase("home")) {
            url = "/home.html";

        } else if (action.equalsIgnoreCase("createRecord")) {
            int bloodSugar;

            // get parameters passed in from the request
            String email = request.getParameter("email");
            String bloodSugarString = request.getParameter("bloodSugar");
            String date = request.getParameter("date");
            String event = request.getParameter("event");
            String health = request.getParameter("health");
            String notes = request.getParameter("notes");
            

            // validate and convert salary string into a double
            if (bloodSugarString == null || bloodSugarString.isEmpty()) {
                bloodSugar = 0;
            } else {
                bloodSugar = Integer.parseInt(bloodSugarString);
            }

            // store data in an Face object
            Face patient = new Face(0, email, bloodSugar, date, event, health, notes);

            // validate the parameters
            if (email == null || bloodSugarString == null || date == null
                    || event == null || health == null || notes == null || email.isEmpty()
                    || bloodSugarString.isEmpty() || date.isEmpty() ||  event.isEmpty() 
                    || health.isEmpty() || notes.isEmpty()) {
                url = "/createRecord.jsp";
            } else {
                // insert this data record into the database
                DAOSQLite.createRecord(patient, dbPath);
                url = "/home.html";
            }

            // add the user object to the request object so that the data is available on the next page
            request.setAttribute("patient", patient);
            
        } else if (action.equalsIgnoreCase("report")) {
            List<Face> mydata = null;
            mydata = DAOSQLite.retrieveAllRecordsByName(dbPath);
            request.setAttribute("mydata", mydata);
            url = "/displayRecords.jsp";

        } else if (action.equalsIgnoreCase("updateRecord1")) {
            String idString = request.getParameter("userId");
            if (idString == null || idString.isEmpty()) {
                url = "/updateRecord1.jsp";
            } else {
                // get patient
                Face patient = DAOSQLite.retrieveRecordById(Integer.parseInt(idString), dbPath);
                request.setAttribute("patient", patient);
                url = "/updateRecord2.jsp";
            }

        } else if (action.equalsIgnoreCase("updateRecord2")) {
            int userId;
            int bloodSugar;

            // get parameters passed in from the request
            String userIdString = request.getParameter("userId");
            String email = request.getParameter("email");
            String bloodSugarString = request.getParameter("bloodSugar");
            String date = request.getParameter("date");
            String event = request.getParameter("event");
            String health = request.getParameter("health");
            String notes = request.getParameter("notes");

            // validate and convert empId string into an int
            if (userIdString == null || userIdString.isEmpty()) {
                userId = 0;
            } else {
                userId = Integer.parseInt(userIdString);
            }

            // validate and convert salary string into a double
            if (bloodSugarString == null || bloodSugarString.isEmpty()) {
                bloodSugar = 0;
            } else {
                bloodSugar = Integer.parseInt(bloodSugarString);
            }

            // store data in an Face object
            // store data in an Face object
            Face patient = new Face(userId, email, bloodSugar, date, event, health, notes);

            // validate the parameters
            if (userIdString == null || email == null || bloodSugarString == null || date == null
                    || event == null || health == null || notes == null || email.isEmpty()
                    || bloodSugarString.isEmpty() || date.isEmpty() ||  event.isEmpty() 
                    || health.isEmpty() || notes.isEmpty() || userIdString.isEmpty()) {
                url = "/createRecord.jsp";
            } else {
                // insert this data record into the database
                DAOSQLite.updateRecord(patient, dbPath);
                url = "/home.html";
            }

        } else if (action.equalsIgnoreCase("deleteRecord")) {
            String idString = request.getParameter("id");
            if (idString == null || idString.isEmpty()) {
                url = "/deleteRecord.jsp";
            } else {
                // delete this data record from the database
                DAOSQLite.deleteRecord(Integer.parseInt(idString), dbPath);
                url = "/home.html";
            }
            
        } else if (action.equalsIgnoreCase("makeDB")) {
            DAOSQLite.dropTable(dbPath);
            DAOSQLite.createTable(dbPath);
            DAOSQLite.populateTable(dbPath);
            url = "/home.html";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
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
        return "Controller for Patient App";
    }// </editor-fold>

}
