import { Component, OnInit } from '@angular/core';
import { Aula } from '../aula.model';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-read',
  templateUrl: './product-read.component.html',
  styleUrls: ['./product-read.component.css']
})
export class ProductReadComponent implements OnInit {

 // products: Product[]
  aulas: Aula[]
  displayedColumns = ['id','sala','nome', 'aula', 'data', 'inicioAula', 'fimAula', 'acoes'];
//  displayedColumns = ['id', 'name', 'price', 'action']

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.read().subscribe(aulas => {
      this.aulas = aulas
      console.log(aulas)
    })
  }

}
