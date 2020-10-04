package com.wolox.jsontest.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolox.jsontest.controller.cons.MappingConstants;

@Service
public class ProviderService {
	
	@Autowired
	private RestTemplate template;
	
	private String url;
	
	private ObjectMapper oMapper;
	private Map<String, String> queries;
	private MultiValueMap<String, String> params;
	private UriComponentsBuilder uriBuilder;
	
	public ProviderService() {
		oMapper = new ObjectMapper();
		this.makeBaseURL();
	}
	
	private void makeBaseURL() {
		uriBuilder = UriComponentsBuilder.newInstance()
	            .scheme(MappingConstants.HTTP).host(MappingConstants.HOST);
	}
	
	public ProviderService setPath(String path) {
		uriBuilder = uriBuilder.path(path);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public ProviderService setQueryParams(Object obj) {
		if(obj != null){
			queries = oMapper.convertValue(obj, Map.class);
			params = new LinkedMultiValueMap<String, String>();
		    for (Entry<String, String> entry : queries.entrySet()) {
		    	if(entry.getValue() != null) {		
		    		String value = String.valueOf(entry.getValue());
		    		params.add(entry.getKey(), value);
		    	}	        
		    } 
		    uriBuilder =  uriBuilder.queryParams(params);
		}		
		return this;
	}	
	
	public <T> T get(Class<T> ObjectResponse) {
		url = uriBuilder.build().toUriString();
		this.makeBaseURL();
		return template.getForObject(url, ObjectResponse);
	}
}
