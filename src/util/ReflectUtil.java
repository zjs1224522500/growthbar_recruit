package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Version:v1.0 (description:  )
 */
public class ReflectUtil {

	public static String findEmptyField(Object object) throws Exception {

		String fieldNames = null;
		boolean submitSuccess = true;

		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			String beanName = name.substring(0, 1).toUpperCase() + name.substring(1);
			Method m = object.getClass().getMethod("get" + beanName);
			String value = (String) m.invoke(object);
			if (null == value || "".equals(value)) {
				fieldNames = name;
				submitSuccess = false;
			}
		}
		if (submitSuccess) {
			return null;
		} else {
			return fieldNames + "格式有误哦！";
		}
	}

	/**
	 * 反射对象
	 *
	 * @return 是否有数据为null
	 */
	public static boolean reflectObject(Object obj) throws Exception {
		boolean len = true;

		// 获取实体类的所有属性，返回Field数组
		Field[] field = obj.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 将属性的首字符大写，方便构造get，set方法
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			System.out.println("属性为：" + name);
			Method m = obj.getClass().getMethod("get" + name);
			// 调用getter方法获取属性值
			String value = (String) m.invoke(obj);
			if (value != null) {
				System.out.println("属性值为：" + value);
			} else {
				System.out.println("属性值为：空");
				len = false;
				return len;
			}
		}
		return len;
	}

	/**
	 * 反射 list
	 *
	 * @return 第几行数据
	 */
	public static Integer reflectList(List list) {
		int count = 1;
		try {
			for (int i = 0; i <= list.size(); i++) {
				Class clazz = list.get(i).getClass();
				// 获取实体类的所有属性，返回Field数组
				Field[] field = clazz.getClass().getDeclaredFields();
				// 遍历所有属性
				for (int j = 0; j < field.length; j++) {
					// 获取属性的名字
					String name = field[j].getName();
					// 将属性的首字符大写，方便构造get，set方法
					name = name.substring(0, 1).toUpperCase() + name.substring(1);
					// 获取属性的类型
					String type = field[j].getGenericType().toString();
					// 如果type是类类型，则前面包含"class "，后面跟类名
					System.out.println("属性为：" + name);
					Method m = clazz.getClass().getMethod("get" + name);
					// 调用getter方法获取属性值
					String value = (String) m.invoke(clazz);
					if (value != null) {
				/*System.out.println("属性值为：" + value);*/
					} else {
			   /* System.out.println("属性值为：空");*/
						return count;

					}

				}
				count++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

}
