package controller;

import model.Student;
import service.IServiceStudent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    IServiceStudent student = new IServiceStudent();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showAll(request, response);
                break;
            case "create":
                showFormAdd(request,response);
                break;
            case "update":
                showFormUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;

        }
    }
//    public void search (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        List<Student> studentList = null;
//        String search = request.getParameter("search");
//        if (search != null) {
//            studentList =student.findProductByName(search);
//        } else {
//            studentList = student.findAll();
//        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
//        request.setAttribute("list", studentList);
//        dispatcher.forward(request, response);
//    }




    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = null;
        String search = request.getParameter("search");
        if (search != null) {
            studentList =student.findProductByName(search);
        } else {
            studentList = student.findAll();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        request.setAttribute("list", studentList);
        dispatcher.forward(request, response);
    }
  public void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(request, response);
    }
    public void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        Student student1 = student.findStudentById(id);
        request.setAttribute("student",student1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);
    }
    public void delete(HttpServletRequest request , HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        student.delete(id);
        response.sendRedirect("http://localhost:8080/student?action=home");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                Add(request,response);
                break;
            case "update":
                Edit(request,response);
                break;


        }
    }
    public void Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String date = request.getParameter("date");
       String address = request.getParameter("address");
       int phone = Integer.parseInt(request.getParameter("phone"));
       String email = request.getParameter("email");
       int classroom = Integer.parseInt(request.getParameter("class"));
        Student student1= new Student(name,date,address,phone,email,classroom);
        student.add(student1);
        response.sendRedirect("http://localhost:8080/student?action=home");
    }
    public void Edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        int classroom = Integer.parseInt(request.getParameter("idClass"));
        Student student1 = new Student(name,date,address,phone,email,classroom);
        student.update(id,student1);
        response.sendRedirect("http://localhost:8080/student?action=home");

    }


}