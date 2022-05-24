import annotation.MyAnnotation;

import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        System.out.println(classLoader.getName());
        Class<Main> mainClass = Main.class;
        System.out.println(mainClass.getPackageName());
        ByteBuffer.allocateDirect(10);

    }



}
