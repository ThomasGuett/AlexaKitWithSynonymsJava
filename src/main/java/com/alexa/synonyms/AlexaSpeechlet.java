package com.alexa.synonyms;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;

/**
 * @author Thomas Guett
 */
public class AlexaSpeechlet implements SpeechletV2
{
	/* (non-Javadoc)
	 * 
	 * @see com.amazon.speech.speechlet.SpeechletV2#onSessionStarted(com.amazon.speech.json.SpeechletRequestEnvelope) */
	@Override
	public void onSessionStarted( SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope )
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * 
	 * @see com.amazon.speech.speechlet.SpeechletV2#onLaunch(com.amazon.speech.json.SpeechletRequestEnvelope) */
	@Override
	public SpeechletResponse onLaunch( SpeechletRequestEnvelope<LaunchRequest> requestEnvelope )
	{
		// TODO Auto-generated method stub
		return handleWelcomeIntent( );
	}

	/* (non-Javadoc)
	 * 
	 * @see com.amazon.speech.speechlet.SpeechletV2#onIntent(com.amazon.speech.json.SpeechletRequestEnvelope) */
	@Override
	public SpeechletResponse onIntent( SpeechletRequestEnvelope<IntentRequest> requestEnvelope )
	{
		//		Session session = requestEnvelope.getSession( ); // e.g. save conversation infos
		IntentRequest request = requestEnvelope.getRequest( );
		Intent intent = request.getIntent( );
		switch ( intent.getName( ) )
		{
		case "AMAZON.StopIntent":
			return handleStopIntent( );
		case "AMAZON.CancelIntent":
			return handleCancelIntent( );
		case "AMAZON.HelpIntent":
			return handleHelpIntent( );
		default:
			return handleWelcomeIntent( );
		}
	}

	private SpeechletResponse handleWelcomeIntent( )
	{
		return SpeechletHelper.say( "Hallo" );
	}

	/* (non-Javadoc)
	 * 
	 * @see com.amazon.speech.speechlet.SpeechletV2#onSessionEnded(com.amazon.speech.json.SpeechletRequestEnvelope) */
	@Override
	public void onSessionEnded( SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope )
	{
		// TODO Auto-generated method stub

	}

	/**
	 * required Method for submitting your skill
	 * 
	 * @return
	 */
	private SpeechletResponse handleStopIntent( )
	{
		return SpeechletHelper.say( "bis zum nächsten mal" );
	}

	/**
	 * required Method for submitting your skill
	 * 
	 * @return
	 */
	private SpeechletResponse handleCancelIntent( )
	{
		return SpeechletHelper.say( "OK" );
	}

	/**
	 * required Method for submitting your skill
	 * 
	 * @return
	 */
	private SpeechletResponse handleHelpIntent( )
	{
		return SpeechletHelper.say( "du kannst zum Beispiel Hallo sagen" );
	}
}
