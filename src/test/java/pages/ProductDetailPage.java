package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(){
        super();
    }

    @AndroidFindBy(accessibility = "test-Description")
    public WebElement productDescription;

}
