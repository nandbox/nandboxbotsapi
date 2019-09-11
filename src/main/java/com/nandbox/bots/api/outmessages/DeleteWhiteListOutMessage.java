package com.nandbox.bots.api.outmessages;

import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONObject;

/**
 * @author Hossam
 *
 */
public class DeleteWhiteListOutMessage extends OutMessage {

	protected static final String KEY_USERS = "users";

	private List<String> users = new ArrayList<>();

	public DeleteWhiteListOutMessage() {
		this.method = OutMessageMethod.deleteWhitelist;
	}

	@Override
	public JSONObject toJsonObject() {
		JSONObject obj = super.toJsonObject();
		if (users != null) {
			obj.put(KEY_USERS, users);
		}

		return obj;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

}
