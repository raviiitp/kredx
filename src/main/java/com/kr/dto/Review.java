package com.kr.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * A review.
 */
public class Review implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String productId;
	String userId;
	String profileName;
	String helpfullness;
	Float score;
	long time;
	String summary;
	String text;
	
	public Review() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public Review(String productId, String userId, String profileName, String helpfullness, Float score, long time, String summary, String text) {
		super();
		this.id = UUID.randomUUID().toString();
		this.productId = productId;
		this.userId = userId;
		this.profileName = profileName;
		this.helpfullness = helpfullness;
		this.score = score;
		this.time = time;
		this.summary = summary;
		this.text = text;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getHelpfullness() {
		return helpfullness;
	}

	public void setHelpfullness(String helpfullness) {
		this.helpfullness = helpfullness;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((helpfullness == null) ? 0 : helpfullness.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((profileName == null) ? 0 : profileName.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (helpfullness == null) {
			if (other.helpfullness != null)
				return false;
		} else if (!helpfullness.equals(other.helpfullness))
			return false;
		if (id != other.id)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (time != other.time)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", productId=" + productId + ", userId=" + userId + ", profileName=" + profileName + ", helpfullness=" + helpfullness
				+ ", score=" + score + ", time=" + time + ", summary=" + summary + ", text=" + text + "]";
	}
	
}
