package com.kr.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.kr.dto.Review;
import com.kr.parser.ReviewMemCache;

@Named(value = "SearchService")
public class SearchService {

	@Inject
	private ReviewMemCache reviewMemCache;

	@PostConstruct
	public void start() {
	}

	public List<Review> search(List<String> queries, int numReview) {
		return getTopReviews(queries, numReview);
	}

	public ArrayList<Review> getTopReviews(List<String> keyWords, int n) {
		ArrayList<Review> topReviews = new ArrayList<Review>();
		if (0 == n || 0 == keyWords.size()) {
			return topReviews;
		}

		HashMap<String, Float> docScore = new HashMap<String, Float>();

		for (String word : keyWords) {
			if (!reviewMemCache.keyDocFreqMap.containsKey(word)) {
				continue;
			}
			HashMap<String, Integer> docFreq = reviewMemCache.keyDocFreqMap.get(word);

			Iterator<?> it = docFreq.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				String docId = (String) pair.getKey();
				int freq = (int) pair.getValue();
				if (docScore.containsKey(docId)) {
					docScore.put(docId, docScore.get(docId) + freq);
				} else {
					docScore.put(docId, freq+ (100 * ((Review)reviewMemCache.reviewsMap.get(docId)).getScore() )/1000 );
				}
				//it.remove();
			}
		}

		TreeMap<String, Float> docScoreSorted = (TreeMap<String, Float>) sortByValues(docScore);

		for (Map.Entry<String, Float> entry : docScoreSorted.entrySet()) {
			if (n <= topReviews.size()) {
				break;
			}

			String key = entry.getKey();
//			Double value = entry.getValue();
			topReviews.add(reviewMemCache.reviewsMap.get(key));
		}

		return topReviews;
	}

	public <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
}
