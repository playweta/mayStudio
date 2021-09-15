package cc.maystudio.febs.common.exception;

/**
 * mayStudio系统内部异常
 *
 * @author mayStudio
 */
public class FebsException extends RuntimeException {

    private static final long serialVersionUID = -994962710559017255L;

    public FebsException(String message) {
        super(message);
    }
}
