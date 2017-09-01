package org.equinox.api.data;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.http.internal.ParameterMap;
import org.mule.transformer.AbstractMessageTransformer;

public class MessageTransformer extends AbstractMessageTransformer {

	@Override
	@SuppressWarnings("unchecked")
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		ParameterMap queryParam = message.getInboundProperty("http.query.params");
		String method = message.getInboundProperty("http.method");
		if (method.equalsIgnoreCase("GET")) {
			HashMap<String, Object> requestPayload = new HashMap<String, Object>();
			requestPayload.putAll(queryParam);
			return requestPayload;
		} else {
			HashMap<String, Object> requestPayload = new HashMap<String, Object>();
			requestPayload.putAll(message.getPayload(Map.class));
			return requestPayload;
		}
	}

}
