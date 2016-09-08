package com.kr.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.google.gson.Gson;
import com.kr.constant.Constant;
import com.kr.dto.Review;

@Named(value = "TextFileReader")
public class TextFileReader {

	private final static Logger log = LoggerFactory.getLogger(TextFileReader.class);
	
	private int MAX;

	@Inject
	private Environment env;
	
	FileInputStream file;
	InputStreamReader reader;
	BufferedReader br;
	
	@PostConstruct
	public void init() {
		MAX = Integer.parseInt(env.getProperty(Constant.MAX));
	}

	public void start() {
		File targetFile = new File(env.getProperty(Constant.TargetFileName));
		if(!targetFile.exists()) {
			File inputFile = new File(env.getProperty(Constant.OriginalFileName));
			if(inputFile.exists()){
				try {
					file = new FileInputStream(inputFile);

					reader = new InputStreamReader(file);
					br = new BufferedReader(reader);
					read();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				log.warn("No review file exists");
			}

		} else {
			log.info("Food review file exists");
		}
	}

	public void read() {
		log.info("Reading from food.txt...");
		String line = null;
		LinkedList<Review> reviewList = new LinkedList<Review>();
		Review review = null;
		try {
			while ((line = br.readLine()) != null) {

				if (line.startsWith("product/productId:")) {
					review = new Review();
					line = line.replaceFirst("product/productId:\\s+", "");
					review.setProductId(line.trim());

				} else if (review != null && line.startsWith("review/userId:")) {
					line = line.replaceFirst("review/userId:\\s+", "");
					review.setUserId(line.trim());

				} else if (review != null && line.startsWith("review/profileName:")) {
					line = line.replaceFirst("review/profileName:\\s+", "");
					review.setProfileName(line.trim());

				} else if (review != null && line.startsWith("review/helpfulness:")) {
					line = line.replaceFirst("review/helpfulness:\\s+", "");
					review.setHelpfullness(line.trim());

				} else if (review != null && line.startsWith("review/score:")) {
					line = line.replaceFirst("review/score:\\s+", "");
					try {
						Float score = Float.parseFloat(line.trim());
						review.setScore(score);
					} catch (Exception e) {

					}

				} else if (review != null && line.startsWith("review/time:")) {
					line = line.replaceFirst("review/time:\\s+", "");
					try {
						Long time = Long.parseLong(line.trim());
						review.setTime(time);
					} catch (Exception e) {

					}

				} else if (review != null && line.startsWith("review/summary:")) {
					line = line.replaceFirst("review/summary:\\s+", "");
					review.setSummary(line.trim());
					
				} else if (review != null && line.startsWith("review/text:")) {
					line = line.replaceFirst("review/text:\\s+", "");
					review.setText(line.trim());

					reviewList.add(review);

					if(reviewList.size() > MAX){
						break;
					}
					review = null;
				} else {
					review = null;
				}

			}
			
			if(reviewList.size() > 0){
				saveToCSV(reviewList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveToCSV(LinkedList<Review> reviewList) {
		log.info("Writing to food_review.txt");
		String file = "food_review.txt";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			if (reviewList != null && reviewList.size() > 0) {
				String json = new Gson().toJson(reviewList);
				fos.write(json.getBytes());
			}
		} catch (Exception e) {
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
			}
		}
		log.info("Written to food_review.txt");
	}
}
