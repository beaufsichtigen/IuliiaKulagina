package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalsInfo;

public class MetalColorsForm extends Form<MetalsInfo> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons odds;

    @FindBy(name = "custom_radio_even")
    public RadioButtons even;

    @FindBy(css = "#elements-checklist input")
    public Checklist elements;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @UI("div[ui=droplist]")
    public MultiSelector vegetablesAllElements;

    @FindBy(css = "#salad-dropdown input")
    public Checklist vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    @Override
    public void fill(MetalsInfo metalsForm) {
        odds.select(metalsForm.getSummary().get(0));
        even.select(metalsForm.getSummary().get(1));
        elements.checked().forEach(elements::select);
        metalsForm.getElements().forEach(elements::select);
        colors.select(metalsForm.getColor());
        metals.select(metalsForm.getMetals());
        vegetablesAllElements.doubleClick();
        vegetables.checked().forEach(vegetables::select);
        metalsForm.getVegetables().forEach(vegetables::select);
        submit.click();
    }
}
