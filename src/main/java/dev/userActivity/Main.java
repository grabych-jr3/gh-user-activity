package dev.userActivity;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length == 0){
            System.out.println("Usage: github-activity <username>");
            return;
        }
        String username = args[0];
        UserActivity userActivity = new UserActivity(username);
        userActivity.groupByEvent();
    }
}
