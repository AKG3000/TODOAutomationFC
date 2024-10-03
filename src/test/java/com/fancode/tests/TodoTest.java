package com.fancode.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fancode.api.RequestService;
import com.fancode.models.Todo;
import com.fancode.tests.data.UserDataProvider;
import com.fancode.utils.DeserializeUtils;
import com.fancode.utils.TodoUtils;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public class TodoTest {
	/*
	 * NOTE : Case for no users in the city is currently handled
	 *  	  using dataProvider(No test cases are run).
	 * */
	@Test(dataProvider = "userDataProvider",dataProviderClass=UserDataProvider.class)
	void verifyUsersFromCityFancodeHaveCompletedMoreThan50PercentTasks(int userId) throws IOException {
		//Given
		System.out.println("Test for User with UserID : " +userId+" started");
		Response response = RequestService.getTodo(userId);
		String responseBody = response.getBody().asString();
		List<Todo> todos = DeserializeUtils.deserializeTodoResponse(responseBody);
		//then
		double completedPercentage = TodoUtils.calculateCompletedTaskPercentageForUsers(todos);
		Assert.assertTrue(completedPercentage > 50,"Test failed for UserId "+userId + " where its completedTaskPercentage is "+completedPercentage);
		System.out.println("Test for User with UserID : " +userId+" ended");
	}
}
