package com.GetPostApi.Restcontroller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.GetPostApi.entity.Student;
import com.GetPostApi.repo.StudentRepository;



@RestController
public class StudentController {
	
		
		@Autowired
		private StudentRepository studentrepo;
		
		@GetMapping("/course/{id}") //hatoes example
		public EntityModel<Student> getbookinfo(@PathVariable Integer id)
		{
			Optional<Student> student = studentrepo.findById(id);
			 EntityModel<Student> resource = EntityModel.of(student.get());

			  // linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getallStudent());

			    
			
			Link withrel= WebMvcLinkBuilder.linkTo(
					      WebMvcLinkBuilder.methodOn(StudentController.class)
					      .getallStudent()).withRel("age_student");
			resource.add(withrel);
		    return resource;
		  }
			
			
		
		
		

	@GetMapping(     // we need to send accept =applcation/json or xml in header from postman to test this service bcoz this api will produce in both format
				value={"/student/{sid}"},
				produces= {
						"application/json",
						"application/xml"
						}
				)
		public ResponseEntity<Student> getStudentById(@PathVariable Integer sid)
		
		{
			Optional<Student> findById = studentrepo.findById(sid);
			if(findById.isPresent()) {
				Student st=findById.get();
				return new ResponseEntity<>(st,HttpStatus.OK);
				
			}else {
			return new ResponseEntity<>(null,HttpStatus.OK);
			//(HttpStatus.OK);
			}
		}
		
	
		
		@GetMapping(     // we need to send accept =applcation/json or xml in header from postman to test this service bcoz this api will produce in both format
				value="/student",
				produces= {
						"application/json",
						"application/xml"
						}
				)
		public ResponseEntity<List<Student>> getStudentByAge(@RequestParam Integer studentAge)
		
		{
			List<Student> getStudentByAge = studentrepo.findByStudentAgeGreaterThanEqual(studentAge);
				return new ResponseEntity<>(getStudentByAge,HttpStatus.OK);
				
		}
		
		
		@GetMapping(     // we need to send accept =applcation/json or xml in header from postman to test this service bcoz this api will produce in both format
				value="/all-student",
				produces= {
						"application/json",
						"application/xml"
						}
				)
		public ResponseEntity<List<Student>> getallStudent()
		
		{
			List<Student> findAll = studentrepo.findAll();
				return new ResponseEntity<>(findAll,HttpStatus.OK);
				
		}
		


		@PostMapping(     // we need to send content type =applcation/json or xml in header from postman to test this service bcoz this api will consume in both format
				value={"/student"},
				consumes= {
						"application/json",
						"application/xml"
						}
				)
		public ResponseEntity<String> addStudent(@RequestBody Student student)
		{
			String msg=null;
			Student save=studentrepo.save(student);
			if(save.getStudentId() !=null)
			{
				msg="saved";
			}
			else {
				msg="failed";
			}
			//Student st1=studentservice.getStudent();
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			//(HttpStatus.OK);
			
		}

		
		
		
	}


