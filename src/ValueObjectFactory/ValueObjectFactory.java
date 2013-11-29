package ValueObjectFactory;

import java.lang.reflect.InvocationTargetException;

public class ValueObjectFactory {
	public Object makeValueObject(String className) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		Object ref = Class.forName(className).getConstructor(new Class[0]).newInstance(new Object[0]);
		return ref;
	}
}
