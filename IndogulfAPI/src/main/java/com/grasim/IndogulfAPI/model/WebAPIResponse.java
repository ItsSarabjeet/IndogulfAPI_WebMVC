package com.grasim.IndogulfAPI.model;

import java.util.Collection;
import java.util.List;

public class WebAPIResponse<T> {

	private Integer resultCount;
	private WebAPIResponseStatus status;
	private WebAPIResponseType type;
	private Collection<T> resultList;
	private T resultItem;
	private String error;
	private String message;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public WebAPIResponseStatus getStatus() {
		return status;
	}

	public void setStatus(WebAPIResponseStatus status) {
		this.status = status;
	}


	public WebAPIResponseType getType() {
		return type;
	}

	public void setType(WebAPIResponseType type) {
		this.type = type;
	}

	public T getResultItem() {
		return resultItem;
	}

	public void setResultItem(T resultItem) {
		this.resultItem = resultItem;
	}

	public Collection<T> getResultList() {
		return resultList;
	}

	public void setResultList(Collection<T> resultList) {
		this.resultList = resultList;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "WebAPIResponse [resultCount=" + resultCount + ", status=" + status + ", type=" + type + ", resultList="
				+ resultList + ", resultItem=" + resultItem + ", error=" + error + ", message=" + message + ", token="
				+ token + "]";
	}

}
