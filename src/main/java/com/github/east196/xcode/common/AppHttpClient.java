package com.github.east196.xcode.common;

import retrofit.RestAdapter;

public class AppHttpClient {
	public static void main(String[] args) {
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://localhost:18080")
				.setLogLevel(RestAdapter.LogLevel.FULL).build();
	}

}
