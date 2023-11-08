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
public class SelectYBean implements Serializable {
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void validateSelectY(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {
        if (o == null || Double.parseDouble(o.toString()) < -5 || Double.parseDouble(o.toString()) > 5) {
            FacesMessage message = new FacesMessage("Неверный формат данных в Y");
            throw new ValidatorException(message);
        }
    }

}
