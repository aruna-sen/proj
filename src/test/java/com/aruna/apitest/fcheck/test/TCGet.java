package com.aruna.apitest.fcheck.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//to check api using restassured
public class TCGet {
	@Test
	void getReqCheck()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"/api/users/2");
		String str=res.getBody().asString();
		System.out.println("body:"+str);
		String ct=res.getHeader("Content-Type");
	System.out.println(ct);
Assert.assertEquals(ct,"application/json; charset=utf-8");
String ctser=res.getHeader("Server");
Assert.assertEquals(ctser,"cloudflare");
int scod=res.getStatusCode();
System.out.println("scod:"+scod);
Assert.assertEquals(scod,200);
long ti=res.getTime();
System.out.println("time"+ti);
String s=res.jsonPath().get("data.first_name");
System.out.println(s);
Assert.assertEquals(s,"Janet");
	}

}
