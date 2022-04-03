import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeserService } from '../employeeser.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees!: Employee[];

  constructor(private empls:EmployeeserService,private rout:Router) { }

  ngOnInit(): void {
    this.getempl();
    console.log(this.getempl());
  
  }

  getempl(){
    this.empls.fetchData().subscribe(data=>{
      this.employees=data;
    })
  }


  del(id:number) {
    this.empls.delete(id).subscribe(data =>{
      console.log(data);
      this.getempl();
    })
  }

  update(id:number){
    this.rout.navigate(["update",id]);
  }




}
