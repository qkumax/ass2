interface WebDriver 
{
    public void getElement(); // This method is used to get an element in the WebDriver.
    public void selectElement(); // This method is used to select an element in the WebDriver.
}

class ChromeDriver implements WebDriver 
{
    @Override
    public void getElement() 
    {
        System.out.println("Get element from ChromeDriver"); // Implementation of getting an element in ChromeDriver.
    }

    @Override
    public void selectElement() 
    {
        System.out.println("Select element from ChromeDriver"); // Implementation of selecting an element in ChromeDriver.
    }
}

class IEDriver
{
    public void findElement() 
    {
        System.out.println("Find element from IEDriver"); // Implementation of finding an element in IEDriver.
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver"); // Implementation of clicking an element in IEDriver.
    }
}

class WebDriverAdapter implements WebDriver 
{
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) 
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() 
    {
        ieDriver.findElement(); // Adapter pattern: Mapping the getElement method to the IEDriver's findElement method.
    }

    @Override
    public void selectElement() 
    {
        ieDriver.clickElement(); // Adapter pattern: Mapping the selectElement method to the IEDriver's clickElement method.
    }
}

public class AdapterPattern
{
    public static void main(String[] args) 
    {
        ChromeDriver a = new ChromeDriver();
        a.getElement(); // Using the ChromeDriver to get and select elements.

        IEDriver e = new IEDriver();
        e.findElement(); // Using the IEDriver to find an element.
        e.clickElement(); // Using the IEDriver to click an element.

        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement(); // Using the adapted IEDriver through the WebDriverAdapter to get an element.
        wID.selectElement(); // Using the adapted IEDriver through the WebDriverAdapter to select an element.
    }
}