package com.example.backend_payment.Controller;

import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.DAO.DAOImplementation.Student_PaymentDAOImplementation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/payment")
public class Student_Payment_Controller extends Application {
    Student_PaymentDAOImplementation student_paymentDAOImplementation=new Student_PaymentDAOImplementation();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_payment(Student_Payment student_payment){
        System.out.println(student_payment);
        if(student_paymentDAOImplementation.addPayment(student_payment)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all(){
        List<Student_Payment> student_paymentList = student_paymentDAOImplementation.getAllPaymentsList();
        return Response.status(200).entity(student_paymentList).build();
    }

    @GET
    @Path("/get_all_payment_for_bill/{bill_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_payment_for_bill(@PathParam("bill_id") int bill_id){
        List<Student_Payment> student_paymentList = student_paymentDAOImplementation.getPaymentList(bill_id);
        return Response.status(200).entity(student_paymentList).build();
    }
    @GET
    @Path("/get/{p_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_payment(@PathParam("p_id") int id){
        System.out.println(id);
        Student_Payment student_payment= student_paymentDAOImplementation.getPayment(id);
        if(student_payment!=null){
            return Response.status(200).entity(student_payment).build();
        }
        return Response.status(400).entity("Failure in getting payment details").build();
    }
}
