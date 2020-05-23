package com.seed.world.test2020_1;

/**
 * @author Administrator
 *
 */
public class App1 {

	public String replaceSpace(StringBuffer str) {
		String s = " ";
		int i = -1;
		StringBuffer buffer2 ;
		StringBuffer buffer1  = str;
		while((i = str.indexOf(s))!=-1) {
			buffer2 = new StringBuffer(buffer1.substring(i+1));
			buffer1 =  new StringBuffer( buffer1.substring(0, i));
			buffer1.append("%20").append(buffer2);
		}
		return buffer1.toString();
		/*
		if(str.length() == 0) return "";
		char[] test = str.toString().toCharArray();
		char[] test2 = new char[test.length*3];
		int count =0;
		for(int i =0, j = 0;i<test.length;i++,j++) {
			if(test[i]==' ') {
				test2[j]='%';
				j++;
				test2[j]='2';
				j++;
				test2[j]='0';
			}else{
				test2[j] = test[i];
			}
			count = j;
		}
		return String.valueOf(test2).substring(0, count+1);*/
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = " ";
		String c = " ";
		char[] b = a.toCharArray();
		char[] clst = b;
		char b0 = b[0];
		char c0 = c.toCharArray()[0];
		System.out.println(b.hashCode());
		System.out.println(c.toCharArray().hashCode());
		System.out.println(a.hashCode());
		System.out.println(c.hashCode());

		System.out.println(b.equals(clst));
		
		StringBuffer string = new StringBuffer("\"hello world\"");
//		string.append("eeee");
		System.out.println(string.indexOf(" "));
		System.out.println();
		StringBuffer buffer2 = new StringBuffer(string.substring(string.indexOf(" ")+1));
		StringBuffer buffer1 =  new StringBuffer( string.substring(0, string.indexOf(" ")));
		buffer1.append("%20").append(buffer2);
		System.out.println(buffer1);
//		if(string.length() == 0) return "";
		char[] test = string.toString().toCharArray();
		char[] test2 = new char[test.length*3];
		int count =0;
		for(int i =0, j = 0;i<test.length;i++,j++) {
			if(test[i]==' ') {
				test2[j]='%';
				j++;
				test2[j]='2';
				j++;
				test2[j]='0';
			}else{
				test2[j] = test[i];
			}
			count = j;
		}
		System.out.print(String.valueOf(test2).substring(0, count+1));
	}
}
