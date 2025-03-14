package com.nandbox.bots.api.inmessages;

import com.nandbox.bots.api.data.Chat;
import com.nandbox.bots.api.data.SignupUser;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class BlackList {

	private static final String KEY_BLACKLIST = "blacklist";
	private static final String KEY_EOP = "eop";
	private static final String KEY_USERS = "users";
	private static final String KEY_CHAT = "chat";
	private static final String KEY_APP_ID = "app_id";

	private String eop;
	private Chat chat;
	// private Users users;
	// private ArrayList <Users> arrayUser = new ArrayList<>();
	private SignupUser[] users;
	private Long appId;

	public BlackList(JSONObject jsonObj) {

		JSONObject obj = (JSONObject) jsonObj.get(KEY_BLACKLIST);

		this.eop = (String) obj.get(KEY_EOP);

		this.chat = obj.get(KEY_CHAT) == null ? null : new Chat((JSONObject) obj.get(KEY_CHAT));
		this.appId =jsonObj.get(KEY_APP_ID) != null
				? Long.parseLong(String.valueOf(jsonObj.get(KEY_APP_ID)))
				: null;
		JSONArray usersArrayObj = (JSONArray) obj.get(KEY_USERS);
		this.users = new SignupUser[usersArrayObj.size()];
		for (int i = 0; i < usersArrayObj.size(); i++) {
			users[i] = new SignupUser((JSONObject) usersArrayObj.get(i));
		}

	}

	public JSONObject toJsonObject() {

		JSONObject obj = new JSONObject();

		if (users != null) {

			JSONArray usersArrayObjnew = new JSONArray();
			for (int i = 0; i < users.length; i++) {
				usersArrayObjnew.add(users[i].toJsonObject());
			}
			obj.put(KEY_USERS, usersArrayObjnew);
		}
		if (appId!=null){
			obj.put(KEY_APP_ID,appId);
		}
		if (chat != null) {
			obj.put(KEY_CHAT, chat.toJsonObject());
		}
		if (eop != null) {
			obj.put(KEY_EOP, eop);
		}

		return obj;

	}

	public String getEop() {
		return eop;
	}

	public void setEop(String eop) {
		this.eop = eop;
	}

	public Chat getChat() {
		return chat;
	}
	public Long getAppId(){
		return appId;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public SignupUser[] getUsers() {
		return users;
	}

	public void setUsers(SignupUser[] users) {
		this.users = users;
	}

}
