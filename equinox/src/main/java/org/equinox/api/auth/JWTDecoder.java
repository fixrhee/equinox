package org.equinox.api.auth;

import org.mule.module.http.internal.ParameterMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTDecoder {

	public String decodeJWTHMAC256(ParameterMap request) throws Exception {
		DecodedJWT jwt = JWT.decode(request.get("token"));
		return jwt.getId();
	}

}
