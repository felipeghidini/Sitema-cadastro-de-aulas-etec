import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../product.model';
import { Aula } from '../aula.model';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {


  aula: Aula = {
    sala: '',
    nome: '',
    aula: '',
    data: '',
    inicioAula: '',
    fimAula: ''
  }

  constructor(private productService: ProductService,
      private router: Router) { }

  ngOnInit(): void {
  }

  createProduct(): void {
    this.productService.create(this.aula).subscribe(() => {
      this.productService.showMessage('Aula cadastrata')
      this.router.navigate(['/aulas'])
    })
  }

  cancel(): void {
    this.router.navigate(['/aulas'])
  }
}
