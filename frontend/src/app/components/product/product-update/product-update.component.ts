import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Aula } from '../aula.model';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  product: Product;
  aula: Aula

  constructor(private productService: ProductService,
              private router: Router,
              private route: ActivatedRoute
          ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.productService.readById(id).subscribe((aula) => {
      this.aula = aula
    })
  }

  updateProduct(): void {
    this.productService.update(this.aula).subscribe(() => {
      this.productService.showMessage("Produto atualizado com sucesso!!!")
      this.router.navigate(["/products"])
    })

  }

  cancel(): void {
    this.router.navigate(["/products"])
  }

}
