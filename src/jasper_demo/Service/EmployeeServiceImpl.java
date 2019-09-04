/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper_demo.Service;

import com.jgoodies.common.base.SystemUtils;
import jasper_demo.Config.ConnectionMySql;
import jasper_demo.Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lts
 */
public class EmployeeServiceImpl implements EmployeeService {

    //db connection requires
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public EmployeeServiceImpl() {
        connection = ConnectionMySql.connectionMySql().getConnection();

    }

    @Override
    public ArrayList<Employee> selectAll() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            preparedStatement = connection.prepareStatement(Employee.SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFistName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setAddress(resultSet.getString("address"));
                employee.setAge(resultSet.getInt("age"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNationalId(resultSet.getString("national_id"));
                employees.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public Employee selectById(int id) {
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(Employee.SELECT_BY_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                employee.setId(resultSet.getInt("id"));
                employee.setFistName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setAddress(resultSet.getString("address"));
                employee.setAge(resultSet.getInt("age"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNationalId(resultSet.getString("national_id"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public JasperPrint printAll() {
        String report = "";

        String workingDir = System.getProperty("user.dir");
        if (SystemUtils.IS_OS_LINUX) {
            report = workingDir + "/Report/AllEmployee.jrxml";
        } else if (SystemUtils.IS_OS_WINDOWS) {
            report = workingDir + "\\Report\\AllEmployee.jrxml";
        }

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(report);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            return jasperPrint;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JasperPrint printbyId(int id) {
        String report = "";

        String workingDir = System.getProperty("user.dir");
        if (SystemUtils.IS_OS_LINUX) {
            report = workingDir + "/Report/Employee.jrxml";
        } else if (SystemUtils.IS_OS_WINDOWS) {
            report = workingDir + "\\Report\\Employee.jrxml";
        }

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(report);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", id);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,hashMap, connection);
            return jasperPrint;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
