import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  templateUrl: 'user.component.html'
})
export class UserComponent implements OnInit {


  form!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.form = this.createForm();
  }

  doUpload() {
    console.log('hi');
  }

  createForm(): FormGroup {
    return this.fb.group({
      name: this.fb.control<string>(''),
      email: this.fb.control<string>(''),
    });
  }

}


