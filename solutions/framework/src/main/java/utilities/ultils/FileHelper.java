package utilities.ultils;

import org.openqa.selenium.Platform;

import java.io.File;

/**
 * Fields class (IN DEVELOPING...)
 *
 * @author  Nhi Dinh
 * @version 1.0
 * @since 02/01/2019
 */
public class FileHelper {

    private static Platform platform = getCurrentPlatform();

    private static String fileLocation;
    public static String MAC_fileLocation;
    public static String WIN_fileLocation;
    public static String macPath;
    public static String winPath;

    //Select file location based on platform
    public static String getFileLocation () {
        switch (platform) {
            case MAC:
                fileLocation = MAC_fileLocation;
                createDirectory(macPath);
                break;
            case WINDOWS:
                fileLocation = WIN_fileLocation;
                createDirectory(winPath);
                break;
            default:
                System.out.println("File path has not been set! There is a problem!\n");
                break;
        }
        return fileLocation;
    }

    //Create the directory path if it does not exist
    public static void createDirectory (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        }else {
            System.out.println("Directory already exists: " + path);
        }
    }

    private static Platform getCurrentPlatform () {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                //PLATFORM_NAME = "WINDOWS";
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                //PLATFORM_NAME = "LINUX";
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                //PLATFORM_NAME = "MAC";
                platform = Platform.MAC;
            }
        }
        return platform;
    }
}
