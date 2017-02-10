/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ehc.elasticsearchdemo.repository;

import com.ehc.elasticsearchdemo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, Long> {

  Customer findByFirstName(String firstName);

  List<Customer> findByLastName(String lastName);

  @Query("{ \"query\": { \"filtered\": { \"filter\": { \"geo_distance\": { \"distance\": \"1km\", \"location\":\"?0\"} } } } }")
  Page<Customer> findByLocationNear(String location, Pageable pageable);
}
