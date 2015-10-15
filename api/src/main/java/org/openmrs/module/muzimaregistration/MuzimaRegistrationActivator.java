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
package org.openmrs.module.muzimaregistration;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.muzima.api.service.DataService;
import org.openmrs.module.muzimaforms.api.MuzimaFormService;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class MuzimaRegistrationActivator implements ModuleActivator {
	
	protected Log log = LogFactory.getLog(getClass());
		
	/**
	 * @see ModuleActivator#willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing Muzima Registration Module");
	}
	
	/**
	 * @see ModuleActivator#contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("Muzima Registration Module refreshed");
	}
	
	/**
	 * @see ModuleActivator#willStart()
	 */
	public void willStart() {
		log.info("Starting Muzima Registration Module");
	}
	
	/**
	 * @see ModuleActivator#started()
	 */
	public void started() {
		log.info("Muzima Registration Module started");
		DataService dataService = Context.getService(DataService.class);
		log.info("Registration module will start processing: " + dataService.getAllQueueData().size());

		MuzimaFormService muzimaFormService = Context.getService(MuzimaFormService.class);
		log.info("Available forms are: " + muzimaFormService.getAll().size());
	}
	
	/**
	 * @see ModuleActivator#willStop()
	 */
	public void willStop() {
		log.info("Stopping Muzima Registration Module");
	}
	
	/**
	 * @see ModuleActivator#stopped()
	 */
	public void stopped() {
		log.info("Muzima Registration Module stopped");
	}
		
}
