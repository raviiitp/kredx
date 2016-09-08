package com.kr.rest;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kr.constant.Constant;
import com.kr.dto.Review;
import com.kr.dto.TestQueryResult;
import com.kr.fileio.TestQueryService;
import com.kr.fileio.TextFileReader;
import com.kr.service.SearchService;

@RestController
public class SearchController {
	
	private final static Logger log = LoggerFactory.getLogger(SearchController.class);
	
	@Inject
	private SearchService searchService;
	
	@Inject
	private TestQueryService testQueryService;
	
	@Inject
	private Environment env;

	@RequestMapping(value = "/searchctrl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchQueries(@RequestParam(value="queries") List<String> queries, @RequestParam(value="numReview") int numReview, HttpServletRequest request) {

		List<Review> reviews = null;

		if (queries != null) {
			long startTime = System.nanoTime();
			reviews = searchService.search(queries, numReview);
			long endTime = System.nanoTime();
			log.info("Searched in " + ((endTime - startTime) / 1000000) + " milliseconds");
			
		}

		if (reviews == null) {
			reviews = new LinkedList<Review>();
		}

		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/runTestQueries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> runTestQueries(HttpServletRequest request) {

		
		long timeDiff = testQueryService.runQueries(); 
		
		TestQueryResult testQueryResult = new TestQueryResult();
		testQueryResult.setTimeDiff(timeDiff);
		testQueryResult.setNoOfTestQueries(Integer.parseInt(env.getProperty(Constant.TestQueriesSize)));

		return new ResponseEntity<>(testQueryResult, HttpStatus.OK);
	}
	
}
