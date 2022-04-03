import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Employee } from '../employee';
import { EmployeeserService } from '../employeeser.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  empl: Employee = new Employee();
  constructor(private empser:EmployeeserService,private router:Router,private ar:ActivatedRoute) { }

  id!:number;
  ngOnInit(): void {
    this.id=this.ar.snapshot.params['id'];
    this.empser.getEmplById(this.id).subscribe(data => {
      this.empl=data;
    }, error => console.log(error)
    );
  }


  goToempl(){
    this.router.navigate(['/empl'])
  }


  onSubmit(){
    console.log(this.empl);
    this.empser.updateEmpl(this.id,this.empl).subscribe(data =>{
      this.goToempl();
    },
    error => console.log(error)
    )
  }


}
