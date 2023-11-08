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
public class SelectXBean implements Serializable {
    private boolean selectedM4;
    private boolean selectedM3;
    private boolean selectedM2;
    private boolean selectedM1;
    private boolean selected0;
    private boolean selected1;
    private boolean selected2;
    private boolean selected3;
    private boolean selected4;
    private SelectX lastSelected;

    public SelectXBean() {
        lastSelected = SelectX.UNSELECTED;
    }

    public void setSelectedM4(boolean selectedM4) {
        this.selectedM4 = selectedM4;
    }
    public void setSelectedM3(boolean selectedM3) {
        this.selectedM3 = selectedM3;
    }
    public void setSelectedM2(boolean selectedM2) {
        this.selectedM2 = selectedM2;
    }
    public void setSelectedM1(boolean selectedM1) {
        this.selectedM1 = selectedM1;
    }
    public void setSelected0(boolean selected0) {
        this.selected0 = selected0;
    }
    public void setSelected1(boolean selected1) {
        this.selected1 = selected1;
    }
    public void setSelected2(boolean selected2) {
        this.selected2 = selected2;
    }
    public void setSelected3(boolean selected3) {
        this.selected3 = selected3;
    }
    public void setSelected4(boolean selected4) {
        this.selected4 = selected4;
    }

    public boolean isSelectedM4() {
        return selectedM4;
    }

    public boolean isSelectedM3() {
        return selectedM3;
    }


    public boolean isSelectedM2() {
        return selectedM2;
    }


    public boolean isSelectedM1() {
        return selectedM1;
    }


    public boolean isSelected0() {
        return selected0;
    }


    public boolean isSelected1() {
        return selected1;
    }
    public boolean isSelected2() {
        return selected2;
    }
    public boolean isSelected3() {
        return selected3;
    }
    public boolean isSelected4() {
        return selected4;
    }


    public SelectX getLastSelected() {
        return lastSelected;
    }

    public double getValue() {
        return lastSelected.getValue();
    }
    public void valueByDefault(){
        if (lastSelected == SelectX.UNSELECTED){
            lastSelected = SelectX.PLUS0;
            System.out.println("Set value by default for X: 0");
        }
    }

    public void valueChanged(int value) {
        switch (value){
            case (-4) -> {
                setSelectedM4(true);
                lastSelected = SelectX.MINUS4;
            }
            case (-3) -> {
                setSelectedM3(true);
                lastSelected = SelectX.MINUS3;
            }
            case (-2) -> {
                setSelectedM2(true);
                lastSelected = SelectX.MINUS2;
            }
            case (-1) -> {
                setSelectedM1(true);
                lastSelected = SelectX.MINUS1;
            }
            case  (0) -> {
                setSelected0(true);
                lastSelected = SelectX.PLUS0;
            }
            case  (1) -> {
                setSelected1(true);
                lastSelected = SelectX.PLUS1;
            }
            case  (2) -> {
                setSelected2(true);
                lastSelected = SelectX.PLUS2;
            }
            case  (3) -> {
                setSelected3(true);
                lastSelected = SelectX.PLUS3;
            }
            case  (4) -> {
                setSelected4(true);
                lastSelected = SelectX.PLUS4;
            }
            default -> System.out.println("Некорректное значение X");
        }

        System.out.println(lastSelected);
    }

    public void validateSelectX(FacesContext context, UIComponent component, Object value) {
        if (lastSelected.getValue() == null) {
            FacesMessage message = new FacesMessage("Please, select at least one checkbox!");
            throw new ValidatorException(message);
        }
    }
}
