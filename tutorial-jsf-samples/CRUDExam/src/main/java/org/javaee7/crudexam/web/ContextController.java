package org.javaee7.crudexam.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.javaee7.crudexam.web.util.JDBCConnection;

/**
 *
 * @author Masudul Haque
 */
@Named
@RequestScoped
public class ContextController {
    private String formId="formId";
    private ResultSet resultSet;
    public void load() {
        Connection con=JDBCConnection.getConnection();
        try {
            PreparedStatement ps=con.prepareStatement("select * from book");
            resultSet=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ContextController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void test() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Object controller =  facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null,"bookController");
        Object name =  facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), controller,"name");
        System.out.println("Controller Bean : " + name);
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
    
    

}
