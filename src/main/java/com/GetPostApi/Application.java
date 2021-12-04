package com.GetPostApi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.GetPostApi.entity.Student;
import com.GetPostApi.repo.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		/*StudentRepository studentRepository= run.getBean(StudentRepository.class);
		
		Student st=new Student(101,"Raju","raju@gamil.com",22);
		Student st1=new Student(102,"ANIL","anil@gamil.com",23);
		Student st2=new Student(201,"alok","alok@gamil.com",20);
		Student st3=new Student(103,"akshay","akashay@gamil.com",20);
		//Student st4=new Student(102,"ANIL","anil@gamil.com",23);
		List<Student> studentList = Arrays.asList(st,st1,st2,st3);
		studentRepository.saveAll(studentList);
		*/
	}

}
