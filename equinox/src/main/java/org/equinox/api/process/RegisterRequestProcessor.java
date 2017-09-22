package org.equinox.api.process;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.equinox.api.process.Utils;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.module.client.MuleClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class RegisterRequestProcessor implements Callable {

	private HazelcastInstance instance;
	private Configurator configurator;

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String otp = Utils.GenerateRandomNumber(6);
		String reqID = UUID.randomUUID().toString();
		IMap<String, String> registerMap = instance.getMap("RegisterRequestMap");
		registerMap.put(reqID, otp);

		MuleClient client;
		client = new MuleClient(configurator.getMuleContext());
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("NOTIFICATION_TYPE", "registerRequest");
		header.put("NOTIFICATION_URL", "sms.notification");
		client.dispatch("NotificationVM", otp, header);

		return reqID + ":" + otp;
	}

	public HazelcastInstance getInstance() {
		return instance;
	}

	public void setInstance(HazelcastInstance instance) {
		this.instance = instance;
	}

	public Configurator getConfigurator() {
		return configurator;
	}

	public void setConfigurator(Configurator configurator) {
		this.configurator = configurator;
	}

}
