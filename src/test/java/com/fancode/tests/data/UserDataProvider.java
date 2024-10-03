package com.fancode.tests.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.fancode.api.RequestService;
import com.fancode.models.UserLocation;
import com.fancode.utils.DeserializeUtils;
import com.fancode.utils.UserUtils;

import io.restassured.response.Response;

public class UserDataProvider {
	 	
	public List<UserLocation> getUsers() throws IOException{
		Response response = RequestService.getUsers();
		String responseBody = response.getBody().asString();
		List<UserLocation> userLocations = DeserializeUtils.deserializeUserResponse(responseBody);
		return userLocations;
	}
	
	public List<UserLocation> getUsersFromCity(double minLat,double maxLat,double minLng,double maxLng) throws IOException{
		List<UserLocation> userLocations = getUsers();
		List<UserLocation> userLocationsInCity =  UserUtils.filterUsersByGeo(userLocations, minLat, maxLat, minLng, maxLng);
		return userLocationsInCity;
	}
	
	@DataProvider(name = "userDataProvider")
	public Object[] userDataProvider() throws IOException {
		int[] userIds = getUsersFromCity(-40,5,5,100).stream().mapToInt(UserLocation::getId).toArray();
		Integer[] integerArray = Arrays.stream(userIds) 
				.boxed() 
				.toArray(Integer[]::new);
		return Arrays.copyOf(integerArray, integerArray.length, Object[].class);
	}
}
