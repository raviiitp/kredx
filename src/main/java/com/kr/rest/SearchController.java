package com.kr.rest;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kr.dto.Review;
import com.kr.service.SearchService;

@RestController
public class SearchController {
	
	@Inject
	private SearchService searchService;

	@RequestMapping(value = "/searchctrl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchQueries(@RequestParam(value="queries") List<String> queries, @RequestParam(value="numReview") int numReview, HttpServletRequest request) {

		List<Review> reviews = null;

		if (queries != null) {
			reviews = searchService.search(queries, numReview);
		}

		if (reviews == null) {
			reviews = new LinkedList<Review>();
		}

		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
}
