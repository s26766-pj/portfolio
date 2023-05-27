package org.springframework.samples.petclinic.patient;

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

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
class PatientController {

	private static final String VIEWS_PATIENT_CREATE_OR_UPDATE_FORM = "patients/createOrUpdateForm";

	private final PatientRepository patients;

	public PatientController(PatientRepository clinicService) {
		this.patients = clinicService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("patient")
	public Patient findPatientById(@PathVariable(name = "patientId", required = false) Integer patientId) {
		return patientId == null ? new Patient() : this.patients.findById(patientId);
	}

	@GetMapping("/patients/new")
	public String initCreationForm(Map<String, Object> model) {
		Patient patient = new Patient();
		model.put("patient", patient);
		return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/patients/new")
	public String processCreationForm(@Valid Patient doc, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
		}
		Patient patient = new Patient();
		this.patients.save(patient);
		return "redirect:/patients/" + patient.getId();
	}

	@GetMapping("/patients/find")
	public String initFindForm() {
		return "patients/findpatients";
	}

	@GetMapping("/patients")
	public String processFindForm(@RequestParam(defaultValue = "1") int page, Patient patient, BindingResult result,
								  Model model) {
		// allow parameterless GET request for /patients to return all records
		if (patient.getLastName() == null) {
			patient.setLastName(""); // empty string signifies the broadest possible search
		}

		// find patients by last name
		Page<Patient> patientsResults = findPaginatedForpatientsLastName(page, patient.getLastName());
		if (patientsResults.isEmpty()) {
			// no patients found
			result.rejectValue("lastName", "notFound", "not found");
			return "patients/findpatients";
		}

		if (patientsResults.getTotalElements() == 1) {
			// 1 patient found
			patient = patientsResults.iterator().next();
			return "redirect:/patients/" + patient.getId();
		}

		// multiple patients found
		return addPaginationModel(page, model, patientsResults);
	}

	private String addPaginationModel(int page, Model model, Page<Patient> paginated) {
		model.addAttribute("listpatients", paginated);
		List<Patient> listpatients = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listpatients", listpatients);
		return "patients/patientsList";
	}

	private Page<Patient> findPaginatedForpatientsLastName(int page, String lastname) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return patients.findByLastName(lastname, pageable);
	}

	@GetMapping("/patients/{patientId}/edit")
	public String initUpdatePATIENTForm(@PathVariable("patientId") int patientId, Model model) {
		Patient patient = this.patients.findById(patientId);
		model.addAttribute(patient);
		return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/patients/{patientId}/edit")
	public String processUpdatePATIENTForm(@Valid Patient patient, BindingResult result,
									   @PathVariable("patientId") int patientId) {
		if (result.hasErrors()) {
			return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
		}

		patient.setId(patientId);
		this.patients.save(patient);
		return "redirect:/patients/{patientId}";
	}

	/**
	 * Custom handler for displaying a patient.
	 * @param patientId the ID of the patient to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@GetMapping("/patients/{patientId}")
	public ModelAndView showPATIENT(@PathVariable("patientId") int patientId) {
		ModelAndView mav = new ModelAndView("patients/PATIENTDetails");
		Patient patient = this.patients.findById(patientId);
		mav.addObject(patient);
		return mav;
	}

}
