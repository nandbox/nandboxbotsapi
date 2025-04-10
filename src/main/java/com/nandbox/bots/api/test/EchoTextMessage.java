package com.nandbox.bots.api.test;

import com.nandbox.bots.api.Nandbox;
import com.nandbox.bots.api.Nandbox.Api;
import com.nandbox.bots.api.NandboxClient;
import com.nandbox.bots.api.data.*;
import com.nandbox.bots.api.inmessages.*;

import com.nandbox.bots.api.outmessages.SetChatMenuOutMessage;
import com.nandbox.bots.api.outmessages.SetNavigationButtonOutMessage;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class EchoTextMessage {

	public static final String TOKEN = "90091783774349926:0:y6tujiDtlZQhZeAGDMFiRfsUVIi54G";
	//90090684265505180 => channel Helloooo
	//90090684293000559 => main app
	//90089584801743482 => basyone (user)
	//90089584778203966 => hesham22yy (user)
	//90089584759479548 => hamed (user)

	public static void main(String[] args) throws Exception {
		NandboxClient client = NandboxClient.get();
		client.connect(TOKEN, new Nandbox.Callback() {
			Nandbox.Api api = null;
			@Override
			public void onConnect(Api api) {
				System.out.println("Authenticated");
				try {
					SetChatMenuOutMessage setChatMenuOutMessage = new SetChatMenuOutMessage();
					setChatMenuOutMessage.setChatId("90090684340969360");
					setChatMenuOutMessage.setApp_id(90090684298937728L);
					SetNavigationButtonOutMessage nv = new SetNavigationButtonOutMessage();


					String jsonString = "[\n" +
							"  {\n" +
							"    \"menu_id\": \"XPN97fuGgQyXy9f\",\n" +
							"    \"cat\": \"menu\",\n" +
							"    \"menu_name\": \"First Menu\",\n" +
							"    \"menu_group\": \"xrDiQUheNzMpOwQ\",\n" +
							"    \"menu_version\": \"23xg7aYtxWbvPpwK\",\n" +
							"    \"menu_order\": 0,\n" +
							"    \"rows\": [\n" +
							"      {\n" +
							"        \"row_id\": \"r_0ga0Jla7UGw4dQi\",\n" +
							"        \"row_order\": 0,\n" +
							"        \"menu_id\": \"XPN97fuGgQyXy9f\",\n" +
							"        \"cells\": [\n" +
							"          {\n" +
							"            \"cell_id\": \"b_Hw1zp6f57YzU1NA\",\n" +
							"            \"form\": \"button\",\n" +
							"            \"style\": \"filled\",\n" +
							"            \"cell_order\": 0,\n" +
							"            \"version\": \"s83V6bGzaJIaYFZl\",\n" +
							"            \"callback\": \"b_Hw1zp6f57YzU1NA\",\n" +
							"            \"label\": \"Filled\"\n" +
							"          },\n" +
							"          {\n" +
							"            \"cell_id\": \"b_uu1zq6Vo9jt3j9H\",\n" +
							"            \"form\": \"button\",\n" +
							"            \"style\": \"filled\",\n" +
							"            \"cell_order\": 1,\n" +
							"            \"version\": \"tSQhFcU0ZAEDciHc\",\n" +
							"            \"callback\": \"b_uu1zq6Vo9jt3j9H\",\n" +
							"            \"label\": \"Filled\"\n" +
							"          }\n" +
							"        ],\n" +
							"        \"row_version\": \"r_0ga0Jla7UGw4dQi\"\n" +
							"      }\n" +
							"    ]\n" +
							"  }\n" +
							"]";
					JSONParser parser = new JSONParser(-1);
					JSONArray arr = (JSONArray) parser.parse(jsonString);
					nv.setChatId("90090684340969360");
					nv.setApp_id(90090684298937728L);
					nv.setNavigation_button("XPN97fuGgQyXy9f");
					api.send(nv);
					setChatMenuOutMessage.setMenus(arr);
					setChatMenuOutMessage.setReference(1234L);
					setChatMenuOutMessage.setEcho(1);
					api.send(setChatMenuOutMessage);
				}catch (Exception e){

				}
				this.api = api;

			}

			@Override
			public void onReceive(IncomingMessage incomingMsg) {
				if (incomingMsg.isTextMsg()) {
					String chatId = incomingMsg.getChat().getId(); // get your chat Id
					String text = incomingMsg.getText(); // get your text message
					api.sendText(chatId, text,incomingMsg.getAppId());
				}
			}

			@Override
			public void onReceive(JSONObject obj) {
				System.out.println(obj.toJSONString());
			}

			@Override
			public void onClose() {

			}

			@Override
			public void onError() {

			}

			@Override
			public void onChatMenuCallBack(ChatMenuCallback chatMenuCallback) {

			}

			@Override
			public void onMessagAckCallback(MessageAck msgAck) {

			}

			@Override
			public void onUserJoinedBot(User user) {

			}

			@Override
			public void onChatMember(ChatMember chatMember) {
				System.out.println(chatMember.toJsonObject());
			}

			@Override
			public void onChatAdministrators(ChatAdministrators chatAdministrators) {
				System.out.println(chatAdministrators.toJsonObject());
			}

			@Override
			public void userStartedBot(User user) {

			}

			@Override
			public void onMyProfile(User user) {
				System.out.println(user.toJsonObject());
			}

			@Override
			public void onProductDetail(ProductItemResponse productItem) {
				System.out.println(productItem.toJsonObject());
			}

			@Override
			public void onCollectionProduct(GetProductCollectionResponse collectionProduct) {

			}



			@Override
			public void listCollectionItemResponse(ListCollectionItemResponse collections) {
				System.out.println(collections.toJsonObject());
			}


			@Override
			public void onUserDetails(User user,Long appId) {
				System.out.println(user.toJsonObject());
			}

			@Override
			public void userStoppedBot(User user) {

			}

			@Override
			public void userLeftBot(User user) {

			}

			@Override
			public void onInlineMessageCallback(InlineMessageCallback inlineMsgCallback) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void permanentUrl(PermanentUrl permenantUrl) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChatDetails(Chat chat,Long appId) {
				System.out.println(chat.toJsonObject());
			}

			@Override
			public void onInlineSearh(InlineSearch inlineSearch) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onBlackListPattern(Pattern blackListPattern) {
				System.out.println(blackListPattern.toJson());
			}

			@Override
			public void onWhiteListPattern(Pattern pattern) {
				System.out.println(pattern.toJson());
			}

			@Override
			public void onBlackList(BlackList blackList) {
				// TODO Auto-generated method stub\
				System.out.println(blackList.toJsonObject());
				
			}

			@Override
			public void onDeleteBlackList(List_ak blackList) {
				System.out.println(blackList.toJsonObject());
			}

			@Override
			public void onWhiteList(WhiteList whiteList) {
				// TODO Auto-generated method stub
				System.out.println(whiteList.toJsonObject());
				
			}

			@Override
			public void onDeleteWhiteList(List_ak whiteList) {
				System.out.println(whiteList.toJsonObject());
			}

			@Override
			public void onScheduleMessage(IncomingMessage incomingScheduleMsg) {
				
			}

			@Override
			public void onWorkflowDetails(WorkflowDetails workflowDetails) {

			}

			/**
			 * @param chat
			 */
			@Override
			public void onCreateChat(Chat chat) {

			}


		});
	}
}