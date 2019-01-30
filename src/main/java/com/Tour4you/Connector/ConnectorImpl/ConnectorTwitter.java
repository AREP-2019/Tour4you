package com.Tour4you.Connector.ConnectorImpl;


import com.Tour4you.Connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(ConnectorTwitter.TWITTER_BASE_URI)
public class ConnectorTwitter implements Connector {

    public static final String TWITTER_BASE_URI= "svc/v1/tweets";

    @Autowired
    private Twitter twitter;


    @RequestMapping(value ="{hashtag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tweet> getTweets(@PathVariable final String hashTag){
        return twitter.searchOperations().search(hashTag,20).getTweets();

    }
}
