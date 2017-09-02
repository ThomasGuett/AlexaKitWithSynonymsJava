package com.alexa.synonyms;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

/**
 * 
 */
public class AlexaSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler
{
	private static final Set<String> supportedApplicationIds = new HashSet<String>( );

	static
	{
		/* This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
		 * Alexa Skill and put the relevant Application Ids in this Set. */
		supportedApplicationIds.add( "amzn1.ask.skill.38ec.." ); // your alexa skill id
	}

	public AlexaSpeechletRequestStreamHandler( )
	{
		super( new AlexaSpeechlet( ), supportedApplicationIds );
	}
}