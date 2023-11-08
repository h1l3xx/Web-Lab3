package io.github.lab3.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class SelectRBean implements Serializable {
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
        System.out.println(value);
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts()
                .add("drawGraphByR(" + (value == null ? 0 : value) + ");");
    }

    public void validateSelectR(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {
        if (o == null) {
            value = null;
            FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts()
                    .add("drawGraphByR(0);");
            FacesMessage message = new FacesMessage("Please, select value!");
            throw new ValidatorException(message);
        }
    }
    public void valueByDefault() {
        if (value == null){
            value = 1.0;
            System.out.println("set value by default for R: 1.0");
        }
    }
}
