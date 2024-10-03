package com.fancode.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fancode.models.Todo;
import com.fancode.models.UserLocation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T deserializeJson(String jsonString, Class<T> valueType) throws IOException {
		return objectMapper.readValue(jsonString, valueType);
	}
	
	// Common method for deserializing a list of objects
    private static <T> List<T> deserializeList(String jsonResponse, Class<T> valueType) throws IOException {
        return objectMapper.readValue(
                jsonResponse,
                objectMapper.getTypeFactory().constructCollectionType(List.class, valueType)
        );
    }
    /*  NOTE : Can be further maintained seperately in different Files.For assignment purpose 
     *         Keeping it in the same file.
     * */
    public static List<UserLocation> deserializeUserResponse(String jsonResponse) throws IOException {
        List<UserLocation> users = new ArrayList<>();
        try {
            users = deserializeList(jsonResponse, UserLocation.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to return users");
        }
        return users;
    }
    
	public static List<Todo> deserializeTodoResponse(String jsonResponse) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Todo> todos = new ArrayList<>();
		try {
			todos = objectMapper.readValue(jsonResponse,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Todo.class));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to return todos");
		}
		return todos;
	}

}