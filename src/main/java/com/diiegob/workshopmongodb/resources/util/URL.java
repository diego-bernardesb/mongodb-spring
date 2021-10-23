package com.diiegob.workshopmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");//decodifica o URL para o padrão 
		} catch (UnsupportedEncodingException e) {
			return "";//retorna uma string vazia caso tenha uma exceção
		}
	}
}
