package facade_design_pattern;

import java.sql.Driver;

// Subsystem Class for Firefox
class Firefox {
    // Get Firefox Driver
    public static Driver getFirefoxDriver() {
        return null;
    }

    // Generate HTML Report for Firefox Driver
    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    // Generate JUnit Report for Firefox Driver
    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

// Subsystem Class for Chrome
class Chrome {
    // Get Chrome Driver
    public static Driver getChromeDriver() {
        return null;
    }

    // Generate HTML Report for Chrome Driver
    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    // Generate JUnit Report for Chrome Driver
    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// Facade Pattern: WebExplorerHelperFacade simplifies interactions with browsers and reports.
class WebExplorerHelperFacade {
    // Generate reports for a given browser, report type, and test.
    public static void generateReports(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

// Main class to demonstrate the Facade Pattern
public class FacadePattern {
    public static void main(String[] args) {
        String test = "CheckElementPresent";

        // Using the Facade to generate reports
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
