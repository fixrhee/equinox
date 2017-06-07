package org.equinox.api.data;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class MessageTransformer extends AbstractMessageTransformer {

	@Override
	@SuppressWarnings("unchecked")
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		HashMap<String, String> requestPayload = new HashMap<String, String>();
		requestPayload.putAll(message.getPayload(Map.class));
		return requestPayload;
	}

}
