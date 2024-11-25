package org.example.p4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudents() throws Exception {
        Connection con = DBCon.getCon();
        List<Student> list = new ArrayList<Student>();
        try(PreparedStatement ps = con.prepareStatement("select * from Student")) {
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"), rs.getInt("percent"), rs.getString("name"),
                        rs.getString("branch"), rs.getString("email")
                ));
            }
        }
        return list;
    }
}
