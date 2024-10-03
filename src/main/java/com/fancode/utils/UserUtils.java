package com.fancode.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.fancode.models.Geo;
import com.fancode.models.UserLocation;

public class UserUtils {
	public static List<UserLocation> filterUsersByGeo(List<UserLocation> users,double minLat,double maxLat,double minLng,double maxLng) {
		return users.stream().filter(user -> {
			Geo geo = user.getAddress().getGeo();
			// Filter by lat and lng
			double userLat = geo.getLat();
			double userLng = geo.getLng();
			return (userLat >= minLat && userLat <= maxLat && userLng >= minLng && userLng <= maxLng);
		}).collect(Collectors.toList());
	}
}
