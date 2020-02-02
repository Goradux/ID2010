package chat.client;
import java.util.Date;

public class afkTimer implements Runnable {
    ChatClient chatClient_;
    int time_;
    public afkTimer(ChatClient chatClient, int time) {
        chatClient_ = chatClient;
        time_ = time;
    }

    public void run() {
        long elapsedTime = 0L;
        long startTime = System.currentTimeMillis();
        boolean notified = false;

        while(true) {
            while(!notified) {
                while (elapsedTime < time_ * 1000) {
                    elapsedTime = (new Date()).getTime() - startTime;
                }
                chatClient_.sendToChat(chatClient_.myName + " has been AFK for " + time_ + "s");
                System.out.println("You have been AFK for " + time_ + "s");
                notified = true;
            }
        }
    }
}