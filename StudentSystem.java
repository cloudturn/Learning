package Practice;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
public class StudentSystem {
    public static boolean isNum(String str){
        Pattern pattern=Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    public static void searchStudent(ArrayList<Student> arr) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要查找的学生姓名或学号：");
        String in = input.next();
        if (arr.indexOf(in) == -1) {
            System.out.println("查无此人");
        } else {
            boolean r = isNum(in);
            if (r == true) {
                for (int i = 0; i < arr.size(); i++) {
                    Student s = arr.get(i);
                    String d = s.getID();
                    if (in == d) {
                        System.out.println("学生姓名：" + s.getName());
                    }
                }
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    Student s = arr.get(i);
                    String d = s.getName();
                    if (in == d) {
                        System.out.println("学生id：" + s.getID());
                    }
                }
            }
            System.out.println("查询成功");
        }
    }
    public static void printStudent(ArrayList<Student> arr){
        if(arr.size()==0) {
            System.out.println("没有学生");
        }
        else{
            for(int i=0;i<arr.size();i++){
                Student s=arr.get(i);
                System.out.println("学生id："+s.getID());
                System.out.println("学生姓名："+s.getName());
            }
        }
    }
    public static void delStudent(ArrayList<Student> arr){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入想要删除的学生姓名：");
        String n=input.next();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getName().equals(n)){
                arr.remove(i);
                System.out.println("***删除成功***");
                break;
            }
            if(i==arr.size()-1){
                System.out.println("该学生不存在");
                break;
            }
        }
    }
    public static void changeStudent(ArrayList<Student> arr){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要修改的学生姓名：");
        String n=input.next();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getName().equals(n)) {
                System.out.println("请输入新学号：");
                String m = input.next();
                Student st = new Student();
                st.setID(m);
                System.out.println("请输入新姓名：");
                String nm = input.next();
                st.setName(nm);
                arr.set(i, st);
                System.out.println("修改成功");
            }
        }
    }
    public static void addStudent(ArrayList<Student> arr){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入新生姓名：");
        String name=input.next();
        System.out.println("请输入新生学号：");
        String ID=input.next();
        Student st=new Student();
        st.setName(name);
        st.setID(ID);
        arr.add(st);
        System.out.println("添加成功");
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        ArrayList<Student> arr=new ArrayList<Student>();
        System.out.println("****欢迎进入学生管理系统****");
        while(true){
            System.out.println("***以下选项可供选择***");
            System.out.println("1、查询学生信息");
            System.out.println("2、输出所有学生信息");
            System.out.println("3、删除学生信息");
            System.out.println("4、修改学生信息");
            System.out.println("5、添加学生信息");
            System.out.println("6、退出学生管理系统");
            System.out.println("请根据需要输入序号：");
            int result=in.nextInt();
            if(result==1) {
                searchStudent(arr);
            } else if(result==2) {
                printStudent(arr);
            } else if(result==3) {
                delStudent(arr);
            } else if(result==4) {
                changeStudent(arr);
            }else if(result==5) {
                addStudent(arr);
            } else if(result==6) {
                System.out.println("期待下次使用");
                break;
            } else{
                System.out.println("输入有误请重新输入");
            }
        }
    }

}