package deepCopy;

import java.io.Serializable;

/**
 * @FileName: Student
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/17 16:38
 */
public class Student implements Serializable {


    private String name;
    private String address;
    private String sex;

    private StudentClass studentClass ;

    private transient  String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", studentClass=" + studentClass +
                ", phone='" + phone + '\'' +
                '}';
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
