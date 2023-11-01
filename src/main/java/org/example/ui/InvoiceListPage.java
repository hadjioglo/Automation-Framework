package org.example.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InvoiceListPage {

    private WebDriver driver;

    public InvoiceListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isInvoiceListDisplayed() {
        return true;
    }
}
