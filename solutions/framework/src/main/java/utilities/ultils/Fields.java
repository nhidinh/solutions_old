package utilities.ultils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Fields class (IN DEVELOPING...)
 *
 * @author  Nhi Dinh
 * @version 1.0
 * @since 3/01/2019
 */
public class Fields {
    public static String ROOT_DIRECTORY = System.getProperty("user.dir");
    public static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    //private static Path dirPath = Paths.get(rootDirectory);
    //public static String PROJECT_DIRECTORY = Paths.get(rootDirectory).getParent().toString();

    public static final String DOMAIN = "http://localhost/wordpress";
    public static final String URL_LOGIN = DOMAIN+"/wp-login.php";
    public static final String URL_DASHBOARD = DOMAIN + "/wp-admin/";
    public static final String URL_ADD_NEW = DOMAIN + "/wp-admin/post-new.php";
    public static String API_URI_LOGIN = "http://localhost/wordpress/wp-login.php";
    public static String IMAGE_PATH = ROOT_DIRECTORY + "\\regression-tests\\src\\test\\java\\com\\hansencx\\wordpress_datatest\\media\\dog.jpg";

}
