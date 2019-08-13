/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aksam.jsf.namedbeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ao475
 */
@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException{
    
           Pattern pattern = Pattern.compile(" \\W+@\\W+\\.\\W+");
           Matcher  matcher = pattern.matcher((CharSequence) value);
           HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
           
           String label;
           
           if (htmlInputText.getLabel() == null ||
            htmlInputText.getLabel().trim().equals("")) {
            label = htmlInputText.getId();
            } else {
    
        label = htmlInputText.getLabel();
        }
        if (!matcher.matches()) {
        FacesMessage facesMessage = new FacesMessage(label +
        ": not a valid email address");
        throw new ValidatorException(facesMessage);
}
}
}    
    

