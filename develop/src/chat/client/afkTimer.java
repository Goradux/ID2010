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
                chatClient_.sendToChat("AFK for " + time_ * 1000 + "s");
                notified = true;
            }
        }
    }
}