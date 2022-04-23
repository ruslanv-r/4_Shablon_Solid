import java.util.Date;
import java.util.List;

public class LoggerFiles implements Logger{

public void loggerTolist (String msg, List<String> log){
    Date date = new Date();
    log.add(msg+" - "+date.toString());
}


    @Override
    public void logg(String msg, List<String> log) {
        loggerTolist(msg,log);
    }
}
