import java.io.FileWriter;
import java.io.IOException;

public class Multifilelogger{
    private FileWriter infoWriter;
    private FileWriter errorWriter;

    public Multifilelogger() throws IOException {
        // Open files in append mode
        infoWriter = new FileWriter("info.log", true);
        errorWriter = new FileWriter("error.log", true);
    }

    public void logInfo(String msg) {
        try {
            infoWriter.write("[INFO] " + msg + "\n");
            infoWriter.flush();
        } catch (IOException ignored) {}
    }

    public void logError(String msg) {
        try {
            errorWriter.write("[ERROR] " + msg + "\n");
            errorWriter.flush();
        } catch (IOException ignored) {}
    }

    public void close() {
        try { infoWriter.close(); } catch (IOException ignored) {}
        try { errorWriter.close(); } catch (IOException ignored) {}
    }

    public static void main(String[] args) throws IOException {
        Multifilelogger logger = new Multifilelogger();
        logger.logInfo("Application started");
        logger.logError("Something went wrong");
        logger.logInfo("Application finished");
        logger.close();
    }
}
