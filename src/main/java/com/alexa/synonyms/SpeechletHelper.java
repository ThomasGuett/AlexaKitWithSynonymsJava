package com.alexa.synonyms;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;

/**
 *
 * @author Thomas Guett
 */
public class SpeechletHelper
{
	public static SpeechletResponse say( String speechText )
	{
		SsmlOutputSpeech speech = new SsmlOutputSpeech( );
		speech.setSsml( "<speak>" + speechText + "</speak>" );

		return SpeechletResponse.newTellResponse( speech );
	}

	public static SpeechletResponse say( String speechText, Card card )
	{
		SsmlOutputSpeech speech = new SsmlOutputSpeech( );
		speech.setSsml( "<speak>" + speechText + "</speak>" );
		return SpeechletResponse.newTellResponse( speech, card );
	}

	public static SpeechletResponse ask( String speechText )
	{
		SsmlOutputSpeech speech = new SsmlOutputSpeech( );
		speech.setSsml( "<speak>" + speechText + "</speak>" );
		Reprompt reprompt = new Reprompt( );

		return SpeechletResponse.newAskResponse( speech, reprompt );
	}

	public static SpeechletResponse ask( String speechText, Card card )
	{
		SsmlOutputSpeech speech = new SsmlOutputSpeech( );
		speech.setSsml( "<speak>" + speechText + "</speak>" );
		Reprompt reprompt = new Reprompt( );

		return SpeechletResponse.newAskResponse( speech, reprompt, card );
	}

	public static SpeechletResponse askAgain( String question )
	{
		String speechText = "Ich konnte Ihre Eingabe leider nicht verstehen. " + question;
		return ask( speechText );
	}
}
