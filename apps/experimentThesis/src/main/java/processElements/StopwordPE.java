package processElements;

import java.util.List;

import org.apache.s4.base.Event;
import org.apache.s4.core.ProcessingElement;
import org.apache.s4.core.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilities.EventFactory;
import utilities.Words;

import eda.Tweet;

public class StopwordPE extends ProcessingElement {
	private static Logger logger = LoggerFactory.getLogger(StopwordPE.class);

	EventFactory eventFactory;
	List<String> stopwords;
	Words utilitiesWords;

	Stream<Event> downStream;

	public void setDownStream(Stream<Event> stream) {
		downStream = stream;
	}

	public void onEvent(Event event) {

		Tweet tweet = event.get("tweet", Tweet.class);
		long time = event.get("timeTweet", Long.class);

		String tweetClean = utilitiesWords.replace(stopwords, tweet.getText());

		Tweet newTweet = tweet.getClone();
		newTweet.setTweetClean(tweetClean);
		Event eventOutput = eventFactory.newEvent(newTweet);

		eventOutput.put("levelLanguage", Long.class, getEventCount()
				% getReplicationPE(LanguagePE.class));
		eventOutput.put("timeTweet", Long.class, time);
		downStream.put(eventOutput);

	}

	@Override
	protected void onCreate() {
		logger.info("Create Stopword PE");

		eventFactory = new EventFactory();
		utilitiesWords = new Words();

		stopwords = utilitiesWords
				.readWords("/alumnos/dwladdimiro/S4/experimentThesis/config/stopwords.txt");
	}

	@Override
	protected void onRemove() {
		logger.info("Remove Stopword PE");
	}

}
