/*
 * ComplainantValidator.java
 *
 * Created on Jun 30, 2008 1:46:06 AM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.dms.web.webapp.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.swayam.dms.web.model.Complainant;

/**
 * 
 * @author paawak
 */
public class ComplainantValidator implements Validator {

    @SuppressWarnings("unchecked")
    public boolean supports(Class clazz) {
        System.out
                .println("*********************ComplainantValidator.supports()");
        return Complainant.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub

    }

}
