/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.patient;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @author Dave Syer
 */
@Controller
class VisitController {

	private final PatientRepository patients;

	public VisitController(PatientRepository patients) {
		this.patients = patients;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/**
	 * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
	 * we always have fresh data - Since we do not use the session scope, make sure that
	 * Specialty object always has an id (Even though id is not part of the form fields)
	 * @param patientId
	 * @return Patient
	 */
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("patientId") int patientId,
			Map<String, Object> model) {
		Patient patient = this.patients.findById(patientId);
		model.put("patient", patient);
		Visit visit = new Visit();
		patient.addVisit(visit);
		return visit;
	}

	// Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is
	// called
	@GetMapping("/patients/{patientId}/visits/new")
	public String initNewVisitForm() {
		return "visits/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is
	// called
	@PostMapping("/patients/{patientId}/visits/new")
	public String processNewVisitForm(@ModelAttribute Patient patient, @PathVariable int patientId, @Valid Visit visit,
									  BindingResult result) {
		if (result.hasErrors()) {
			return "visits/createOrUpdateVisitForm";
		}

		patient.addVisit(patientId, visit);
		this.patients.save(patient);
		return "redirect:/patients/{patientId}";
	}

}
