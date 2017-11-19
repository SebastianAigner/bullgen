package providers

import twitter4j.Query
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.QueryResult



class TweetsProvider(val keywords: String) {
    fun provide(): List<Triple<String, String, List<String>>> {
        // The factory instance is re-useable and thread safe.
        val twitter = TwitterFactory.getSingleton()
        val query = Query(keywords)
        val result = twitter.search(query)

        val tweets = result.tweets.map{tweet ->
            Triple(tweet.text, tweet.user.screenName, tweet.hashtagEntities.map{"#" + it.text})}

        // Hashtags are not really needed as the tweet text already contains them
        return tweets
    }
}