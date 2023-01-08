package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.tc.hw7.entities.MetalsInfo;

public class MetalColorsForm extends Form<MetalsInfo> {

    @UI("summary-block")
    public Form summary;


    @FindBy(id = "elements-checklist")
    public Checkbox password;

    @FindBy(id = "submit-button")
    public Button submit;
}
