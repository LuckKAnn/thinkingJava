package deepCopy;

import java.io.*;

/**
 * @FileName: StudentClone
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/17 16:40
 */
public class StudentClone implements Serializable {
    /**
     * 可以把这个直接写成工具类，传入泛型参数
     * @param student
     * @return
     */
    public static Student myClone(Student student){
        Student anotherStu = null;
        try {
            //在内存中开辟一块缓冲区，将对象序列化成流
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(student);

            //找到这一块缓冲区，将字节流反序列化成另一个对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            anotherStu = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return anotherStu;
    }

    public static void main(String[] args) {
        Student student = new Student();

        StudentClass studentClass = new StudentClass();
        studentClass.setClassName("yanjiushengyiban");
        student.setName("张三");
        student.setAddress("地球");
        student.setSex("男");
        student.setPhone("13035568998");
        student.setStudentClass(studentClass);
        System.out.println("第一个学生："+student);

        Student anotherStudent = null;
        System.out.println("深拷贝前的第二个学生："+anotherStudent);

        anotherStudent = myClone(student);
        System.out.println("深拷贝后的第二个学生："+anotherStudent);

        StudentClass studentClass1 = anotherStudent.getStudentClass();
        System.out.println(studentClass1==studentClass);

        System.out.println(System.identityHashCode(studentClass));
        System.out.println(System.identityHashCode(studentClass1));
    }
}
