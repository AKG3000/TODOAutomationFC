package com.fancode.api;

import com.fancode.config.factory.ApiConfigFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestService {
	private RequestService() {
	  }

	private static final String TODOS_ENDPOINT = ApiConfigFactory.getConfig().todosEndpoint();
	private static final String USERS_ENDPOINT = ApiConfigFactory.getConfig().usersEndpoint();

	public static Response getTodo(int userId) {
		return BaseRequestSpecification.getDefaultRequestSpec().param("userId", userId).get(TODOS_ENDPOINT);
	}

	public static Response getUsers() {
		return BaseRequestSpecification.getDefaultRequestSpec().get(USERS_ENDPOINT);
	}

}
