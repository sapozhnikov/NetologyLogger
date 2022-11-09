import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected int num = 1;
    private DateTimeFormatter dtf;
    private static Logger logger;

    private String getLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    private Logger() {
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss ");
    }
    public static Logger getInstance() {
        if (logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + getLocalDateTime() + num++ + "] " + msg);
    }
}