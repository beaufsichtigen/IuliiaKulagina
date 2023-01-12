package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.MetalsInfo;
import com.epam.tc.hw7.forms.HeaderForm;
import com.epam.tc.hw7.forms.MetalColorsForm;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

public class JdiMetalsPage extends WebPage {

    @UI("header")
    public HeaderForm headerMetalsForm;

    @UI("form")
    public MetalColorsForm metalColorsForm;

    @Css(".results li")
    private WebList log;

    public void fillMetalColorForm(MetalsInfo metalInfo) {
        metalColorsForm.fill(metalInfo);
    }

    public List<String> getActualLogFromPage() {
        List<String> actualResult = new ArrayList<>();
        for (WebElement logElement : log) {
            actualResult.add(logElement.getText());
        }
        return actualResult;
    }
}
