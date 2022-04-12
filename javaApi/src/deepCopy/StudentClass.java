package deepCopy;

import java.io.Serializable;

/**
 * @FileName: Class
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/17 16:41
 */
public class StudentClass implements Serializable {

    private  String className;


    @Override
    public String toString() {
        return "Class{" +
                "className='" + className + '\'' +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
