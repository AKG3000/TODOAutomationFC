package com.fancode.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fancode.api.RequestService;
import com.fancode.config.factory.ApiConfigFactory;
import com.fancode.models.Geo;
import com.fancode.models.Todo;
import com.fancode.models.UserLocation;
import com.fancode.tests.data.UserDataProvider;
import com.fancode.utils.DeserializeUtils;
import com.fancode.utils.TodoUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {

	@Test(dataProvider = "userDataProvider",dataProviderClass=UserDataProvider.class)
	void verifyUsersFromCityFancodeHaveCompletedMoreThan50PercentTasks(int user) throws IOException {
		//Given
		Response response = RequestService.getTodo(user);
		String responseBody = response.getBody().asString();
		List<Todo> todos = DeserializeUtils.deserializeTodoResponse(responseBody);
		//then
		double completedPercentage = TodoUtils.calculateCompletedTaskPercentageForUsers(todos);
		Assert.assertTrue(completedPercentage > 50);
	}
}
