package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class Summary extends Form {

    @FindBy(id = "odds-selector")
    public RadioButtons odds;

    @FindBy(id = "even-selector")
    public RadioButtons even;

    @FindBy(id = "calculate-button")
    public Button calculate;

}
