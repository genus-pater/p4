/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelos.util.JsfUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author eborja
 */
@ManagedBean
@RequestScoped
public class reportes {

    private int id_torneo;
    JasperPrint jasperPrint;

    public void reporteGanadores() throws ClassNotFoundException, SQLException, Exception {
        try {
            init("/reportes/reporteGanadores.jasper");
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ClassNotFoundException | SQLException | JRException | FileNotFoundException e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }
    }
    
    public void reporteSanciones() throws ClassNotFoundException, SQLException, Exception {
        try {
            init("/reportes/reporteSanciones.jasper");
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ClassNotFoundException | SQLException | JRException | FileNotFoundException e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }
    }

    public void init(String path) throws JRException, ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties proCredenciales = new Properties();
        proCredenciales.setProperty("user", "postgres");
        proCredenciales.setProperty("password", "123456");
        try (Connection conConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestioncampeonatos", proCredenciales)) {
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
            jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), conConexion);
        }
    }

    public void reporte() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
        try {
            init("/reportes/reporteClasificatoria.jasper");
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ClassNotFoundException | SQLException | JRException | FileNotFoundException e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }

    }

    public reportes() {
    }

    /**
     * @return the id_torneo
     */
    public int getId_torneo() {
        return id_torneo;
    }

    /**
     * @param id_torneo the id_torneo to set
     */
    public void setId_torneo(int id_torneo) {
        this.id_torneo = id_torneo;
    }

}
