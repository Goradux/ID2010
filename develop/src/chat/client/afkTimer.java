package chat.client;

public class afkTimer implements Runnable {

    ChatClient chatClient_;
    public afkTimer(ChatClient chatClient) {
        chatClient_ = chatClient;
    }

    public void run() {
        chatClient_.sendToChat("INSIDE AFK_TIMER");
    }
}