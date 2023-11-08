package io.github.lab3.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@SessionScoped
public class TimeBean implements Serializable {

    public LocalDateTime getNowTime() {
        return LocalDateTime.now();
    }

}
