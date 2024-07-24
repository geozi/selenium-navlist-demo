package my.project;

/**
 * The {@link NavListUtil} class is a utility
 * class that stores the text items found
 * in the nav-list web element.
 */
public class NavListUtil {

    private static final String[] navListItems = {"Company", "Corporate Responsibility",
            "Investor Relations", "Media", "Careers", "Blog"};

    private NavListUtil() {}

    public static String[] getItems() {
        return navListItems;
    }
}
