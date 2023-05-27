package org.springframework.samples.petclinic.doc;

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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.patient.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
class DocController {

	private static final String VIEWS_DOC_CREATE_OR_UPDATE_FORM = "docs/createOrUpdateDOCorm";

	private final DocRepository docs;

	public DocController(DocRepository clinicService) {
		this.docs = clinicService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("doc")
	public Doc findDocById(@PathVariable(name = "docId", required = false) Integer docId) {
		return docId == null ? new Doc() : this.docs.findById(docId);
	}

	@GetMapping("/docs/new")
	public String initCreationForm(Map<String, Object> model) {
		Doc doc = new Doc();
		model.put("doc", doc);
		return VIEWS_DOC_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/docs/new")
	public String processCreationForm(@Valid Doc doc, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_DOC_CREATE_OR_UPDATE_FORM;
		}

		this.docs.save(doc);
		return "redirect:/docs/" + doc.getId();
	}

	@GetMapping("/docs/find")
	public String initFindForm() {
		return "docs/finddocs";
	}

	@GetMapping("/docs")
	public String processFindForm(@RequestParam(defaultValue = "1") int page, Doc doc, BindingResult result,
								  Model model) {
		// allow parameterless GET request for /docs to return all records
		if (doc.getLastName() == null) {
			doc.setLastName(""); // empty string signifies the broadest possible search
		}

		// find docs by last name
		Page<Doc> docsResults = findPaginatedFordocsLastName(page, doc.getLastName());
		if (docsResults.isEmpty()) {
			// no docs found
			result.rejectValue("lastName", "notFound", "not found");
			return "docs/finddocs";
		}

		if (docsResults.getTotalElements() == 1) {
			// 1 patient found
			doc = docsResults.iterator().next();
			return "redirect:/docs/" + doc.getId();
		}

		// multiple docs found
		return addPaginationModel(page, model, docsResults);
	}

	private String addPaginationModel(int page, Model model, Page<Doc> paginated) {
		model.addAttribute("listdocs", paginated);
		List<Doc> listdocs = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listdocs", listdocs);
		return "docs/docsList";
	}

	private Page<Doc> findPaginatedFordocsLastName(int page, String lastname) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return docs.findByLastName(lastname, pageable);
	}

	@GetMapping("/docs/{docId}/edit")
	public String initUpdatePATIENTForm(@PathVariable("docId") int docId, Model model) {
		Doc doc = this.docs.findById(docId);
		model.addAttribute(doc);
		return VIEWS_DOC_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/docs/{docId}/edit")
	public String processUpdateDOCForm(@Valid Doc doc, BindingResult result,
									   @PathVariable("docId") int docId) {
		if (result.hasErrors()) {
			return VIEWS_DOC_CREATE_OR_UPDATE_FORM;
		}

		doc.setId(docId);
		this.docs.save(doc);
		return "redirect:/docs/{docId}";
	}

	/**
	 * Custom handler for displaying a patient.
	 * @param docId the ID of the patient to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@GetMapping("/docs/{docId}")
	public ModelAndView showDOC(@PathVariable("docId") int docId) {
		ModelAndView mav = new ModelAndView("docs/DOCDetails");
		Doc doc = this.docs.findById(docId);
		mav.addObject(doc);
		return mav;
	}

}
