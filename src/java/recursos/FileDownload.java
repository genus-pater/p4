/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Edison
 */
@ManagedBean
@ViewScoped
public class FileDownload {
    private StreamedContent archivoWord;
    private StreamedContent archivoPdf;

    public FileDownload() {
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/pea.doc");
        archivoWord = new DefaultStreamedContent(stream, "application/msword", "Plan_de_Estudios.doc");
        
        stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/pea.pdf");
        archivoPdf = new DefaultStreamedContent(stream, "application/pdf", "Plan_de_Estudios.pdf");
    }

    public StreamedContent getArchivoWord() {
        return archivoWord;
    }

    public void setArchivoWord(StreamedContent archivoWord) {
        this.archivoWord = archivoWord;
    }

    public StreamedContent getArchivoPdf() {
        return archivoPdf;
    }

    public void setArchivoPdf(StreamedContent archivoPdf) {
        this.archivoPdf = archivoPdf;
    }

}
