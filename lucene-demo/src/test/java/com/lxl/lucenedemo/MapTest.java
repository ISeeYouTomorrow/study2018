package com.lxl.lucenedemo;

import org.junit.Test;

import java.util.*;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/29
 */
public class MapTest {

    class Teacher {
        private int id;
        private int age;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "id: " + this.getId() + " ; age: " + this.getAge() + " ; name: " + this.getName();
        }
    }

    class TeacherCompator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.getId()-o2.getId();
        }
    }

    /**
     * compartor----外部比较器，对扩展开放，对修改关闭，不需要修改原有实体类，只需要自定义比较器实现类,供Collections.sort调用即可。
     */
    @Test
    public void compatorTest() {
        List<Teacher> Teachers = new ArrayList<>();
        for(int i=0;i<10;i++){
            Teacher s = new Teacher();
            s.setId(random.nextInt(1000));
            s.setAge(random.nextInt(60));
            s.setName("teacher"+i);
            Teachers.add(s);
        }
        Teachers.sort(new TeacherCompator());
        trace(Teachers);
    }


    /**
     * Comparable 是内部排序器，实现该接口的实体类默认是可以排序的
     */
    class Student implements Comparable<Student>{

        private int id;
        private int age;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "id: " + this.getId() + " ; age: " + this.getAge() + " ; name: " + this.getName();
        }

        @Override
        public int compareTo(Student o) {
            return this.getAge()-o.getAge();
        }
    }

    private Random random = new Random();
    @Test
    public void comparableTest() {
        List<Student> students = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student s = new Student();
            s.setId(i);
            s.setAge(random.nextInt(40));
            s.setName("student"+i);
            students.add(s);
        }
        Collections.sort(students);

        trace(students);
    }

    private void trace(Collection<?> cols){
        for (Object t:cols
             ) {
            System.out.println(t);
        }
    }

    @Test
    public void mapTest() {
        java.util.Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        Set<Integer>keys = map.keySet();
        for (Integer key:keys
             ) {
            System.out.println(key+" = " +map.get(key));
        }

        Set<java.util.Map.Entry<Integer,Integer>> entry = map.entrySet();
        for (java.util.Map.Entry<Integer,Integer> en:entry
             ) {
            System.out.println(en.getKey()+" = "+en.getValue());
        }


        Collection<Integer> values = map.values();
        for (Integer x : values) {
            System.out.println(x);
        }
    }
}
