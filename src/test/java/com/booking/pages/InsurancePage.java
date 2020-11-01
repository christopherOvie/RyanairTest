package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class InsurancePage extends CommonPage {

    @FindBy(xpath = "//button[@class='ry-button--full ng-tns-c167-1 ry-button--gradient-yellow ry-button--large']")
    private WebElementFacade continueBtn;

    public void clickToContinue() {
        awaitVisibility(continueBtn).click();
    }

}
