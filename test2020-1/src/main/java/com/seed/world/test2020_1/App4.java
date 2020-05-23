package com.seed.world.test2020_1;

public class App4 {

	/**
	 *  泛型方法继承中的 detial - jvm识别
	 * @author Administrator
	 *
	 * @param <T>
	 */
	class Super<T>{
		public T test() {
			return null;
		}
	}
	class sub<T> extends Super<T>{
		
		@Override
		public T test() {
			return null;
		}
		
		/*@Override -- error
		public String test() {
			return null;
		}*/
		
	}
	
	class sub0 extends Super<String>{
		
		@Override
		public String test() {
			return null;
		}
	}
}
