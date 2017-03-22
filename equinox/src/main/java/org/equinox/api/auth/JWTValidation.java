package org.equinox.api.auth;

import org.mule.module.http.internal.ParameterMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTValidation {

	private String issuer;

	public String verifyJWTHMAC256(ParameterMap request) throws Exception {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(request.get("secret"))).withIssuer(getIssuer()).build();
		DecodedJWT jwt = verifier.verify(request.get("token"));
		return jwt.getId();
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
}
