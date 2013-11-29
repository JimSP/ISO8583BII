package br.com.cafebinario.iso8583.pojo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class PojoBase {
	public Object setter(String[] values, String[] names) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method[] metodos = this.getClass().getDeclaredMethods();
		Object obj = null;
		for (Method method : metodos) {
			for (String name : names) {
				int index = 0;
				if(("set" + name) .equals(method.getName())){
					obj = method.invoke(this, new Object[]{method.getParameterTypes()[0].cast(values[index])});
				}
				index++;
			}
		}
		
		return obj;
	}
}
