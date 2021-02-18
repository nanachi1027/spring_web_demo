package org.example.api.employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.model.employee.Employee;
import org.example.model.employee.EmployeeResponse;
import org.example.model.response.OperationResponse;
import org.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 * @Author: Mae
 * @Date: 2021/2/18 4:52 上午
 */

@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Employee"})
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRepo employeeRepo;

    @ApiOperation(value = "List of employees", response = EmployeeResponse.class)
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public EmployeeResponse getEmployeesByPage(
            @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
            @RequestParam(value = "employeeid", required = false) Integer employeeId,
            Pageable pageable) {
        EmployeeResponse resp = new EmployeeResponse();
        Employee employee = new Employee();
        if (employeeId != null) {
            employee.setId(employeeId);
        }

        Page<Employee> pg = employeeRepo.findAll(org.springframework.data.domain.Example.of(employee), pageable);
        resp.setItems(pg.getContent());
        resp.setPageStats(pg, true);
        return resp;
    }

    @ApiOperation(value = "Add new employee", response = OperationResponse.class)
    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {"application/json"})
    public OperationResponse addNewEmployee(@RequestBody Employee employee, HttpServletRequest req) {
        OperationResponse resp = new OperationResponse();
        if (this.employeeRepo.exists(employee.getId()) ){
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Unable to add Employee - Employee allready exist ");
        }
        else{
            Employee addedEmployee = this.employeeRepo.save(employee);
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Employee Added");
        }
        return resp;
    }


    @ApiOperation(value = "Delete a Employee", response = OperationResponse.class)
    @RequestMapping(value = "/Employees/{employeeId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public OperationResponse deleteEmployee(@PathVariable("employeeId") Integer employeeId, HttpServletRequest req) {
        OperationResponse resp = new OperationResponse();
        try {
            if (this.employeeRepo.exists(employeeId) ){
                this.employeeRepo.delete(employeeId);
                resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
                resp.setOperationMessage("Employee Deleted");
            }
            else{
                resp.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
                resp.setOperationMessage("No Employee Exist");
            }
        }
        catch ( Exception ge ){
            System.out.println("========= MAE GENERIC EXCEPTION ============");
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
            resp.setOperationMessage(ge.getMessage());
        }

        return resp;
    }
}
