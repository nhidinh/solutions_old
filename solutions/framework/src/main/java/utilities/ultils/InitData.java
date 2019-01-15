package utilities.ultils;

import org.openqa.selenium.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @param
 * @author Nhi Dinh
 * @return
 * @since 1/15/2019
 */


public class InitData {
    public static String CURRENT_DIR = System.getProperty("user.dir");
    public static String PARENT_DIR = getProjectDirectory();
    public static Platform PLATFORM = getCurrentPlatform();
    public static String PLATFORM_NAME;
    public static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    //LOG DIRECTORY AND FILE PATH
    private static String FILE_NAME_LOG = TIMESTAMP + ".log";
    public static String LOG_DIR_PATH = PARENT_DIR+"/logs";
    public static String LOG_FILE_PATH = LOG_DIR_PATH + "/" + FILE_NAME_LOG;
//    public static String LOG_CONFIG_FILE_PATH = "./framework/src/main/java/com/hansencx/solutions/util/logger/log4j.xml";

    //REPORT DIRECTORY PATH
    public static String FILE_NAME_REPORT = "REPORT-"+TIMESTAMP+".html";
    public static String REPORT_DIR_PATH = PARENT_DIR+ "\\test-report" + "\\Report-"+TIMESTAMP;
    public static String REPORT_FILE_PATH = REPORT_DIR_PATH +"/"+FILE_NAME_REPORT;

    ///TEST DATA SOURCE PATH
    public static String TEST_DATASOURCE_PATH = PARENT_DIR+"//data-files//" ;

    // IMAGE PATH
//    public static String IMAGE_PATH = PARENT_DIR + "\\regression-tests\\src\\test\\java\\com\\hansencx\\tests\\wordpress_datatest\\media\\dog.jpg";
    public static String IMAGE_PATH = "..\\regression-tests\\src\\test\\java\\com\\hansencx\\tests\\wordpress_datatest\\media\\dog.jpg";

    //Get current platform
    private static Platform getCurrentPlatform () {
        if (PLATFORM == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                PLATFORM_NAME = "WINDOWS";
                PLATFORM = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                PLATFORM_NAME = "LINUX";
                PLATFORM = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                PLATFORM_NAME = "MAC";
                PLATFORM = Platform.MAC;
            }
        }
        return PLATFORM;
    }

    //Get Project Directory:
    public static String getProjectDirectory() {
        Path dirPath = Paths.get(CURRENT_DIR).toAbsolutePath();
        PARENT_DIR = dirPath.getParent().toString();
        System.out.println("Parent Directory: " + PARENT_DIR);
        return PARENT_DIR;
    }
}
