package br.com.cafebinario.iso8583.anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Destination {
	int posicao();
	String name();
	String type();
	boolean nativo();
	String ipmName();
}
