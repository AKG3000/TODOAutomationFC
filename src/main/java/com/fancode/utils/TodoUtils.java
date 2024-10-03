package com.fancode.utils;

import java.util.List;
import com.fancode.models.Todo;

public class TodoUtils {
	public static double calculateCompletedTaskPercentageForUsers(List<Todo> todos) {
		long completedCount = todos.stream().filter(todo -> todo.isCompleted()).count();
		return ((double) completedCount / todos.size()) * 100;
	}
}
