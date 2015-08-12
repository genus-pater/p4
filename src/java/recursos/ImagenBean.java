/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Edison
 */
@ManagedBean
@ViewScoped
public class ImagenBean {
    private StreamedContent img;

    public ImagenBean() {
        InputStream stream = this.getClass().getResourceAsStream("/resources/imagenes/sprite.png");
    }

    public StreamedContent getImg() {
        return img;
    }

    public void setImg(StreamedContent img) {
        this.img = img;
    }
    
    
}
