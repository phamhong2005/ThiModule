package service;

import model.Student;
import sun.security.mscapi.PRNG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IServiceStudent implements IService<Student> {
    Connection connection = ConnectionMySQL.getConnection();

    @Override
    public void add(Student student) {
        String sql = "INSERT INTO student (name, date,address ,phone,email,idClass)\n" +
                "                VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDate());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassroom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findByid(int id) {
        return -1;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Student student) {
        String sql = "update student set name = ? , date = ? , address = ? , phone = ? , email = ? ,idClass = ? where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getDate());
            statement.setString(3, student.getAddress());
            statement.setInt(4, student.getPhone());
            statement.setString(5, student.getEmail());
            statement.setInt(6, student.getClassroom());
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                String address = resultSet.getString("address");
                int phone = resultSet.getInt("phone");
                String email = resultSet.getString("email");
                int classroom = resultSet.getInt("idClass");
                Student student = new Student(id, name, date, address, phone, email, classroom);
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date");
                String address = resultSet.getString("address");
                int phone = resultSet.getInt("phone");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("idClass");
                Student student = new Student(id, name, dateOfBirth, address, phone, email, classroomId);
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> search(String keyword) {
        String sql = "SELECT * FROM users WHERE name LIKE '%" + keyword + "%'";
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String date = resultSet.getString("date");
            String address = resultSet.getString("address");
            int phone = resultSet.getInt("phone");
            String email = resultSet.getString("email");
            int idClass = resultSet.getInt("idClass");
            Student student = new Student(id, name, date, address, phone, email, idClass);
            list.add(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Student> findProductByName(String nameFind) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student where name like ?;" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nameFind + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                String address = resultSet.getString("address");
                int phone = resultSet.getInt("phone");
                String email = resultSet.getString("email");
                int idClass = resultSet.getInt("idClass");
                Student student = new Student(id,name,date,address,phone,email,idClass);
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
