package com.kr.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.kr.constant.Constant;
import com.kr.parser.ReviewMemCache;
import com.kr.service.SearchService;

@Named(value = "TestQueryService")
public class TestQueryService {

	@Inject
	private Environment env;

	@Inject
	private ReviewMemCache reviewMemCache;
	
	@Inject
	private SearchService searchService;

	private final static Logger log = LoggerFactory.getLogger(TestQueryService.class);

	private List<List<String>> testQueries;

	@PostConstruct
	public void init() {
		testQueries = null;
	}

	public void generateQueryFile() {
		log.info("Creating test queries");
		BufferedWriter writer = null;
		Random random = new Random();
		int wordCountMax = Integer.parseInt(env.getProperty(Constant.WordCountMax));
		int querySize;
		List<String> keys = new ArrayList<String>(reviewMemCache.keyDocFreqMap.keySet());
		try {

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(env.getProperty(Constant.TestQueriesFileName))));

			int testQuerySize = Integer.parseInt(env.getProperty(Constant.TestQueriesSize));
			for (int i = 0; i < testQuerySize; i++) {
				
				
				querySize = random.nextInt(wordCountMax) + 1;
				
				HashSet<String> querySet = new HashSet<String>();
				
				StringBuilder st = new StringBuilder();
				
				while(querySet.size() < querySize){
					String query = keys.get(random.nextInt(keys.size()));
					if(!querySet.contains(query)){
						querySet.add(query);
						st.append(query).append(" ");
					}
				}
				
				writer.write(st.toString().trim());
				writer.newLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void readTextQueriesFromFile() {

		log.info("Reading test queries");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(env.getProperty(Constant.TestQueriesFileName))));
			String line = null;
			while((line = br.readLine()) != null){
				testQueries.add(Arrays.asList(line.split("\\s+")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public long runQueries() {

		log.info("Running test queries");
		File testQueryFileName = new File(env.getProperty(Constant.TestQueriesFileName));
		if (!testQueryFileName.exists()) {
			generateQueryFile();
		}

		if (testQueries == null) {
			testQueries = new LinkedList<List<String>>();
			readTextQueriesFromFile();
		}

		long startTime = System.nanoTime();
		runQueriesUtils();
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000;

	}

	private void runQueriesUtils() {

		for(List<String> testQuery : testQueries){
			searchService.search(testQuery, 20);
		}
	}
}
