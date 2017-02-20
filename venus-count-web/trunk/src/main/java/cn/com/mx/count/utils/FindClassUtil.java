package cn.com.mx.count.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 发现类 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午3:57:34
 */
public class FindClassUtil {
	
	/**
	 * @Description 获取指定包路径下的类 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午3:57:52
	 * @param pk 包路径
	 * @param cls 接口
	 * @return 类列表
	 * @throws ClassNotFoundException
	 */
	public static List<String> getAllAssignedClass(String pk, Class<?> cls) throws ClassNotFoundException {
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		List<String> classNewList = new ArrayList<String>();
		List<String> classList = getClasses(new File(url.getFile()), pk);
		for (String className : classList)
		if (cls.isAssignableFrom(Class.forName(className))) {
			classNewList.add(className);
		}	
		return classNewList;
	}
	
	/**
	 * @Description 迭代获取全部类
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午3:57:52
	 * @param dir 目录
	 * @param pk 包路径
	 * @return 类列表
	 * @throws ClassNotFoundException
	 */
	private static List<String> getClasses(File dir, String pk)
			throws ClassNotFoundException {
		List<String> classList = new ArrayList<String>();
		if (!dir.exists()) {
			return classList;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classList.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classList.add(pk + "." + name.substring(0, name.length() - 6));
			}
		}
		return classList;
	}

}
