package com.proxet.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proxet.api.service.AndroidPushNotificationsService;
import com.proxet.api.service.UserService;

@RestController
public class WebController {

	private final String TOPIC = "JavaSampleApproach";
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/sen 	", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> send(HttpServletRequest servletRequest) throws JSONException {
		String deviceId = servletRequest.getParameter("id");
		String contactNo = servletRequest.getParameter("contactNo");

		if(userService.isContactMappedWithDevice(deviceId, contactNo)){
			return new ResponseEntity<>("Already Mapped", HttpStatus.OK);
		}
		//return 	new ResponseEntity<List<?>>(userService.getMappedAdvertisement(deviceId, contactNo, servletRequest), HttpStatus.OK);

		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", "JSA Notification");
		notification.put("body", "Happy Message!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");

		Map<String, String > map = new HashMap<>();
		map.put("Greeting", "Hello");
		body.put("notification", notification);
		System.out.println(contactNo+" "+deviceId);
		//body.put("data", userService.getMappedAdvertisement(deviceId, contactNo, servletRequest));

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();

		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
}
