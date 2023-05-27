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
package org.springframework.samples.petclinic.doc;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.patient.Patient;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository class for <code>Doc</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public interface DocRepository extends Repository<Doc, Integer> {

	/**
	 * Retrieve all <code>Doc</code>s from the data store.
	 * @return a <code>Collection</code> of <code>Doc</code>s
	 */
	@Transactional(readOnly = true)
	@Cacheable("docs")
	Collection<Doc> findAll() throws DataAccessException;

	/**
	 * Retrieve all <code>Doc</code>s from data store in Pages
	 * @param pageable
	 * @return
	 * @throws DataAccessException
	 */
	@Transactional(readOnly = true)
	@Cacheable("docs")
	Page<Doc> findAll(Pageable pageable) throws DataAccessException;

	/**
	 * Retrieve {@link Doc}s from the data store by last name, returning all patients
	 * whose last name <i>starts</i> with the given name.
	 * @param lastName Value to search for
	 * @return a Collection of matching {@link Doc}s (or an empty Collection if none
	 * found)
	 */

	@Query("SELECT DISTINCT doc FROM Doc doc WHERE doc.lastName LIKE :lastName% ")
	@Transactional(readOnly = true)
	Page<Doc> findByLastName(@Param("lastName") String lastName, Pageable pageable);


	/**
	 * Retrieve an {@link Doc} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link Doc} if found
	 */
	@Query("SELECT doc FROM Doc doc WHERE doc.id =:id")
	@Transactional(readOnly = true)
	Doc findById(@Param("id") Integer id);

	/**
	 * Save an {@link Doc} to the data store, either inserting or updating it.
	 * @param doc the {@link Doc} to save
	 */
	void save(Doc doc);
}
