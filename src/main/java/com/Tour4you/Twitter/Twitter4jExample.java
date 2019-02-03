package com.Tour4you.Twitter;

import twitter4j.*;
import twitter4j.api.FavoritesResources;
import twitter4j.auth.AccessToken;

import java.util.List;

//Twitter API With Java Example
public class Twitter4jExample {
    public static void main(String args[]) {
        Twitter twitter = new TwitterFactory().getInstance();
        // Twitter Consumer key & Consumer Secret
        twitter.setOAuthConsumer("8dTXC7O1W67rwM0nhio9c6oS0", "WzQ0FWatdebg9f9ZvNW7i27w6tOtTeQtC5E2OEJEFJGASFurOp");
        // Twitter Access token & Access token Secret
        twitter.setOAuthAccessToken(new AccessToken("3184443555-RStrNpQHz9izP0a0KulYVHTAR0IIUUmZMCxmOxa",
                "03LSOT5lGpMfL5E9Cqx9XpYMQuMzlO4G3D36jErITZsyL"));
        try {
            // Getting Twitter Timeline using Twitter4j API
            ResponseList statusReponseList = twitter.getUserTimeline(new Paging(1, 5));
            FavoritesResources s= twitter.favorites();
            System.out.println(s.getFavorites());


            // Post a Tweet using Twitter4j API
            //Status status = twitter.updateStatus("Hello Testing From Twitter API");
           // System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (Exception e) {
        }

        try {
            Query query = new Query("Cocaine");
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}