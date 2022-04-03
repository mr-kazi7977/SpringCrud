import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeserService } from '../employeeser.service';

@Component({
  selector: 'app-createemployee',
  templateUrl: './createemployee.component.html',
  styleUrls: ['./createemployee.component.css']
})
export class CreateemployeeComponent implements OnInit {
  empl: Employee = new Employee();

  constructor(private empser:EmployeeserService,private router:Router) { }

  ngOnInit(): void {
  }

  saveEmpl(){
    this.empser.create(this.empl).subscribe(data =>{
      console.log(data);
      this.goToempl();
    },
    error =>console.log(error));
  }

  goToempl(){
    this.router.navigate(['/empl'])
  }


  onSubmit(){
    console.log(this.empl);
    this.saveEmpl();
  }

}
