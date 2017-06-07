package org.equinox.api.auth;

import java.util.HashMap;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTDecoder {

	public String decodeJWTHMAC256(HashMap<String, String> request) throws Exception {
		DecodedJWT jwt = JWT.decode(request.get("token"));
		return jwt.getId();
	}

}
