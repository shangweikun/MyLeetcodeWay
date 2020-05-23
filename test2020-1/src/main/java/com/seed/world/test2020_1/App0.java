
package com.seed.world.test2020_1;

import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class App0 {
	
	static class PrintClassVisitor extends ClassVisitor{

		public PrintClassVisitor( ClassVisitor classVisitor) {
			super(Opcodes.ASM5,classVisitor);
		}

		@Override
		public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
			System.out.println("this is visitField");
			if(cv != null) {
				
			};
			return super.visitField(access, name, descriptor, signature, value);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(Student.class.getName());
		ClassReader cr = new ClassReader(ClassLoader.getSystemResourceAsStream(Student.class.getName().replace(".", "/")+".class"));
		cr.accept(new PrintClassVisitor(new ClassWriter(0)), 0);
	}
	
	
}
