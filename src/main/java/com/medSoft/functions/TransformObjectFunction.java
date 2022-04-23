package com.medSoft.functions;

import java.util.function.Function;

import com.google.gson.Gson;

public class TransformObjectFunction<T, R> {

	Gson gson = new Gson();
	private Class<?> R;
	
	@SuppressWarnings("unchecked")
	public Function<T, R> transformFunction = t -> { return (R)gson.fromJson(gson.toJson(t),R);};

}
