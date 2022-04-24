package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bancibiao
 * @author 
 */
@Data
public class Bancibiao implements Serializable {
    private Integer bcbh;

    private String bcmc;

    private Date bckssj;

    private Date bcjssj;

    private static final long serialVersionUID = 1L;
}