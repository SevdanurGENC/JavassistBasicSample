package com.mycompany.jademo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
/**
 *
 * @author Nano
 */
public class DynamicCodeInsertion {
    public static String packageName = "com.mycompany.jademo";
    public static ClassPool cp;
    public static CtClass cc;
    public static CtMethod m;
    
    public static void main(String[] args) throws Exception
    {
        cp = ClassPool.getDefault();
        cc = cp.get(packageName + ".DemoClass");
        
        cp.makePackage(cp.getClassLoader(), packageName);
        m = cc.getDeclaredMethod("helloWorld");
        m.insertBefore("{System.out.print(\"-->> Method Baslangicinda Calisan Metin \");}");
        
        m.insertAfter("{System.out.print(\"-->> Metod Sonunda Biten Metin\");}");
        
        cc.toClass();
 
        (new DemoClass()).helloWorld();
    }
}