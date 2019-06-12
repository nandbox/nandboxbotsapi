
# nandbox Bot Java Library

[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/nandbox/nandboxbotsapi/blob/master/LICENSE)

A simple to use library to create nandbox Bots in Java

## Usage

Just import  the library to your project with one of the following options:

  1. Using Maven Central Repository:

```xml
    <dependency>
         <groupId>com.nandbox.bots.api</groupId>
		 <artifactId>bots-api</artifactId>
		 <version>1.0</version>
    </dependency>
```
## Build your first bot
After we download the library  now we can easily build your bot by following the next steps:

**1.Setup your configuration file** once you get your configuration data copy it to proprieties file and name it to `config.properties` then add it to your project

If you don't know how to get your configuration data and your token 

- Open your bot in nandbox application and click to `Get token` from right toolbar menu
or watch this video([https://www.youtube.com/channel/UCpBaKSjiN7tzAijq-U4FzxA]([https://www.youtube.com/watch?v=FXb6tjOuxSc&feature=youtu.be](https://www.youtube.com/watch?v=FXb6tjOuxSc&feature=youtu.be))).


you will get data like this:
``` 
token:90091783784280754:0:HJDWBBPmJAnSD5ILIkc6N6QjY3ZzeY
url:wss://w1.nandbox.net:5020/nandbox/api/  
download:https://w1.nandbox.net:5020/nandbox/download/  
upload:https://w1.nandbox.net:5020/nandbox/upload/
```
save your token we will use it later and add other data to config file as we said before 

**2.Create your main class :**  After your create your class and add your main function please call `connect` function and implement necessary methods 

```java
public class MyFirstBot {

	public static void main(String[] args) throws Exception {

		NandboxClient client = NandboxClient.get();
		client.connect(token, new Nandbox.Callback() {
		Nandbox.Api api = null;
		});
	}

}
```
`client.connect(token, new Nandbox.Callback()`  : this method to connect to server please add your bot token  instead of `token`

**3.Make a echo bot** :We will write simple bot that echoes everything we sent to him
```java
	@Override
			public void onConnect(Api api) {
				System.out.println("Authenticated");
				this.api = api;
			}

			@Override
			public void onReceive(IncomingMessage incomingMsg) {
				if (incomingMsg.isTextMsg()) {
					String chatId = incomingMsg.getChat().getId(); // get you chat Id
					String text = incomingMsg.getText(); // get your text message
					api.sendText(chatId, text); // Sending message back as an Echo
				}
			}
```
--
## License 
MIT License

Copyright (c) 2019 nandbox

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

