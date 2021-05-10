import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from './services/employee/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  employeeForm: FormGroup;
  employees: any;


  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
  ) {
  }
  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      idEmp: [''],
      fullname: ['', Validators.required],
      function: ['', Validators.required],
      id_boss: ['', Validators.required],
    })

    this.employeeService.getAllEmployees().subscribe(resp => {
      this.employees = resp;
    },
      error => { console.error(error) }
    )

  }


  guardar(): void {
    this.employeeService.saveEmployee(this.employeeForm.value).subscribe(resp => {
      this.employeeForm.reset();
      // this.employees=this.employees.filter(employee => resp.id!==employee.id)
      // this.employees.push(resp);
      this.employeeService.getAllEmployees().subscribe(resp => {
        this.employees = resp;
      },
        error => { console.error(error) }
      )
    },
      error => { console.error(error) }
    )
  }

  eliminar(employee: any) {
    this.employeeService.deleteEmployee(employee.idEmp).subscribe(resp => {
      console.log(resp)
      if (resp == false) {
        this.employees.pop(employee);
      }
    })
  }

  editar(employee: any) {
    this.employeeForm.setValue({
      idEmp: employee.idEmp,
      fullname: employee.fullname,
      function: employee.function,
      id_boss: employee.id_boss,
    })

    this.employeeService.getAllEmployees().subscribe(resp => {
      this.employees = resp;
    },
      error => { console.error(error) }
    )
  }

}
