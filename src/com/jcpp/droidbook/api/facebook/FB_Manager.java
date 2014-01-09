package com.jcpp.droidbook.api.facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class FB_Manager {

	protected final String APP_ID = "683133638393115";
	protected final String APP_ID_SECRET = "2c36ea0c6d1d2b9bdbf8187aa3fe3abf";
	protected final String ACCESS_TOKEN = "CAAJtTnHZAvRsBAMTuN3tvpmy9AEN2RHXY8Pa5d8irFZAm3w7lDyt5RJEt2dzgGL8ZCFYUKXCP1ZCW3ctZCeZCxlP4HV4ZBn9iFM8xhniR3YAS3p1z6ZC1ruaVlCxXZAmaIKZC5QPKV8E1w0JdKVtdNi15xBBRSJiiCEgzwDKKxWuSn9arBtm7xzZC27QQGFPgqowNQZD";

	/**
	 * This method provides to posting a message on own wall of Facebook.
	 * @param title
	 * @param text
	 */
	public void postComment(String title, String text){

		FacebookClient facebookClient = new DefaultFacebookClient(ACCESS_TOKEN);

		FacebookType publishMessageResponse =
				facebookClient.publish("me/feed", FacebookType.class,
						Parameter.with(title, text));
	}
}

