/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper_demo.Service;

import jasper_demo.Model.Employee;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author lts
 */
public interface EmployeeService {

    ArrayList<Employee> selectAll();

    Employee selectById(int id);

    JasperPrint printAll();

    JasperPrint printbyId(int id);
}
