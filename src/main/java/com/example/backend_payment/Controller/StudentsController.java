package com.example.backend_payment.Controller;

import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.Bean.Students;
import com.example.backend_payment.DAO.DAOImplementation.StudentsDAOImplementation;
import com.example.backend_payment.DAO.StudentsDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentsController extends Application {
    StudentsDAO studentsDAO=new StudentsDAOImplementation();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_student(Students student){
        System.out.println(student);
        if (studentsDAO.addStudent(student)){
            return Response.ok().entity("Success").build();
        }
        return Response.status(401).build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_students(){
        List<Students> students = studentsDAO.getStudentList();
        return Response.ok().entity(students).build();
    }

    @GET
    @Path("/get/{s_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_student(@PathParam("s_id") int id){
        System.out.println(id);
        Students students=studentsDAO.getStudent(id);
        if(students!=null){
            return Response.ok().entity(students).build();
        }
        return Response.status(401).build();
    }

    @GET
    @Path("/get_all_details/{s_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_student_details(@PathParam("s_id") int id){
        System.out.println(id);
        List<Student_Payment> result=studentsDAO.getDetails(id);
        if(result!=null){
            return Response.ok().entity(result).build();
        }
        return Response.status(401).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Students student) {
        Students student1 = studentsDAO.login(student);

        if (student1 == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(student1).build();
    }
}
