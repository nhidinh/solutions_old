package utilities.logger;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import utilities.ultils.Fields;
import utilities.ultils.FileHelper;

/**
 * Log class (IN DEVELOPING...)
 *
 * @author  Nhi Dinh
 * @version 1.0
 * @since
 */
public class Log {
    private static Logger log;
    private static String timeStamp = Fields.TIMESTAMP;
    private static String logFileName = timeStamp + ".log";

    private static String macPath = Fields.ROOT_DIRECTORY + "/regression-tests/logs";
    private static String windowsPath = Fields.ROOT_DIRECTORY + "/regression-tests/logs";

    private static String MAC_Log_location = macPath + "/" + logFileName;
    private static String WIN_Log_location = windowsPath + "\\" + logFileName;

    private static String MAC_ConfigFile_Loc = Fields.ROOT_DIRECTORY + "/framework/src/main/java/utilities/Logger/log4j.xml";
    private static String WIN_ConfigFile_loc = Fields.ROOT_DIRECTORY + "\\framework\\src\\main\\java\\utilities\\Logger\\log4j.xml";
    ;

    public static void initLogger() {
        setLogFileLocation();
        getLog4jConfigurationFile();
        log = Logger.getLogger(Log.class.getName());
    }

    private static void setLogFileLocation() {
        FileHelper.macPath = macPath;
        FileHelper.winPath = windowsPath;
        FileHelper.MAC_fileLocation = MAC_Log_location;
        FileHelper.WIN_fileLocation = WIN_Log_location;
        String logLocation = FileHelper.getFileLocation();

        System.setProperty("logLocation", logLocation);
        System.out.println("Log file is created at: " + logLocation);
    }

    private static void getLog4jConfigurationFile() {
        FileHelper.MAC_fileLocation = MAC_ConfigFile_Loc;
        FileHelper.WIN_fileLocation = WIN_ConfigFile_loc;
        String configLog4jFile = FileHelper.getFileLocation();

        DOMConfigurator.configure(configLog4jFile);
    }

    public static void startLog() {
        initLogger();
        log.info("Start Log...");
    }

    public static void endLog() {
        log.info("End Log...");
    }

    public static void startTestCase(String sTestCaseName) {
        log.info("********************* START TESTCASE: " + sTestCaseName + "*********************");
    }

    public static void endTestCase(String sTestCaseName) {
        log.info("********************* END OF TEST CASE: " + sTestCaseName + "*********************");
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warning(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void trace(String message) {
        log.trace(message);
    }
}
