package com.driver.Repository;

import java.util.*;

import com.driver.model.Student;
import com.driver.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(),teacher);

    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            if(teacherStudentMapping.containsKey(teacher)) {
                teacherStudentMapping.get(teacher).add(student);
            } else {
                teacherStudentMapping.put(teacher, List.of(student));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Student findStudent(String student){
        // your code goes here
        if(studentMap.isEmpty()){
            return null;
        }
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }
        return null;
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        return teacherStudentMapping.get(teacher);
    }

    public List<String> findAllStudents(){
        // your code goes here
        ArrayList<String> list = new ArrayList<>();
        for(String key: studentMap.keySet()){
            list.add(key);
        }
        return list;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
        else{
            System.out.println("teacher not found");
        }
    }
    public void deleteAllTeachers(){
        // your code goes here
        if(teacherMap.isEmpty()){
            System.out.println("No teacher records found");
        }
        else{
            teacherMap.clear();
        }
    }
}