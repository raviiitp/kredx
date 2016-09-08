package com.kr.parser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kr.dto.Review;
import com.kr.fileio.TextFileReader;

@Named(value="ReviewMemCache")
public class ReviewMemCache {
	
	@Inject
	private TextFileReader textFileReader;
	
	private final static Logger log = LoggerFactory.getLogger(ReviewMemCache.class);
	public HashMap<String, HashMap<String, Integer>> keyDocFreqMap;
	public HashMap<String, Review> reviewsMap;
	
	@PostConstruct
	public void start() {
		log.info("Start parsing file");
		keyDocFreqMap = new HashMap<String, HashMap<String, Integer>>();
		reviewsMap = new HashMap<String, Review>();
		textFileReader.start();
		readFile("food_review.txt");
	}
	
	public void readFile(String fileName) {
		try {
			String data = new String(Files.readAllBytes(Paths.get(fileName)));
			List<Review> reviewList = new Gson().fromJson(data, new TypeToken<LinkedList<Review>>() {
			}.getType());
			
			processReviews(reviewList);
		} catch (Exception e) {
		}
	}

	void processReviews(List<Review> reviewList) {
		log.info("Creating cache");
		for (Review review : reviewList) {
			processText(review.getId(), review.getText());
			reviewsMap.put(review.getId(), review);
		}
	}

	void processText(String docId, String textMessage) {
		textMessage = textMessage.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();

		StringTokenizer msgToken = new StringTokenizer(textMessage);
		while (msgToken.hasMoreTokens()) {
			String token = msgToken.nextToken();
			if (keyDocFreqMap.containsKey(token)) {
				HashMap<String, Integer> docFreq = keyDocFreqMap.get(token);
				/*if (docFreq.containsKey(docId)) {
					docFreq.put(docId, docFreq.get(docId) + 1);
				} else {
					docFreq.put(docId, 1);
				}*/
				docFreq.put(docId, 1);
			} else {
				HashMap<String, Integer> docFreq = new HashMap<String, Integer>();
				docFreq.put(docId, 1);
				keyDocFreqMap.put(token, docFreq);
			}
		}
	}
}
