package com.fancode.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fancode.api.RequestService;
import com.fancode.config.factory.ApiConfigFactory;
import com.fancode.models.Geo;
import com.fancode.models.Todo;
import com.fancode.models.UserLocation;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {
	public List<UserLocation> usersInFancodeCity = new ArrayList<>();

	public List<UserLocation> deserializeUserResponse(String jsonResponse) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserLocation> users = new ArrayList<>();
		try {
			users = objectMapper.readValue(jsonResponse,
					objectMapper.getTypeFactory().constructCollectionType(List.class, UserLocation.class));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to return users");
		}
		return users;
	}

	public List<Todo> deserializeTodoResponse(String jsonResponse) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Todo> users = new ArrayList<>();
		try {
			users = objectMapper.readValue(jsonResponse,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Todo.class));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to return todos");
		}
		return users;
	}

	public static boolean isUserFromCityFancode(double latitude, double longitude) {
		return latitude >= -40 && latitude <= 5 && longitude >= 5 && longitude <= 100;
	}

	@DataProvider(name = "userDataProvider")
	public Object[] userDataProvider() {
		int[] userIds = usersInFancodeCity.stream().mapToInt(UserLocation::getId).toArray();

		Integer[] integerArray = Arrays.stream(userIds) // Create an IntStream from the int array
				.boxed() // Box each int to Integer
				.toArray(Integer[]::new); // Collect into an Integer[]

// Step 3: Convert Integer[] to Object[]
		return Arrays.copyOf(integerArray, integerArray.length, Object[].class);
	}

	public static List<UserLocation> filterUsersByGeo(List<UserLocation> users) {
		return users.stream().filter(user -> {
			Geo geo = user.getAddress().getGeo();
			// Filter by lat and lng
			double lat = geo.getLat();
			double lng = geo.getLng();
			return (lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100);
		}).collect(Collectors.toList());
	}

	public static double calculateCompletedTaskPercentage(List<Todo> todos) {
		long completedCount = todos.stream().filter(todo -> todo.isCompleted()).count();
		return ((double) completedCount / todos.size()) * 100;
	}

	@Test
	void verifyAndExtractData() throws IOException {

		Response response = RequestService.getUsers();
		String responseBody = response.getBody().asString();
		List<UserLocation> users = deserializeUserResponse(responseBody);

		usersInFancodeCity = filterUsersByGeo(users);
		Object[] userList = userDataProvider();

		for (Object user : userList) {
			System.out.println(user);
		}

		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}

	@Test(dataProvider = "userDataProvider")
	void verifyUsersInFancodeHave50PercentTasksComplete(int user) throws IOException {
		Response response = RequestService.getTodo(user);
		String responseBody = response.getBody().asString();
		List<Todo> todos = deserializeTodoResponse(responseBody);
		System.out.println(user);
		double completedPercentage = calculateCompletedTaskPercentage(todos);
		Assert.assertTrue(completedPercentage > 50);
	}
}
