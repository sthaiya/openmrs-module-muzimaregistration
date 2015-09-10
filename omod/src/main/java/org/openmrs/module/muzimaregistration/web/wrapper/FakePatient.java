/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.muzimaregistration.web.wrapper;

import org.apache.commons.beanutils.PropertyUtils;
import org.openmrs.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakePatient extends Patient {

    private static final Logger log = LoggerFactory.getLogger(FakePatient.class.getSimpleName());

    private static final String[] properties = new String[]{
            "uuid", "gender", "birthdate", "names", "identifier", "attributes"
    };

    public FakePatient(final Patient patient) {
        for (String property : properties) {
            try {
                Object o = PropertyUtils.getProperty(patient, property);
                PropertyUtils.setProperty(this, property, o);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
