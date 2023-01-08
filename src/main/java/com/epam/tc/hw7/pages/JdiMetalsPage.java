package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.forms.HeaderForm;
import com.epam.tc.hw7.forms.MetalColorsForm;

public class JdiMetalsPage extends WebPage {

    @UI("header")
    public HeaderForm headerMetalsForm;

    @UI("form")
    public MetalColorsForm metalColorsForm;

}
