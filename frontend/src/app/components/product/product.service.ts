import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Product } from './product.model';
import { Observable, EMPTY } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Aula } from './aula.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = "http://localhost:3002/aulas"

  constructor(private snackBar: MatSnackBar,
    private http: HttpClient) { }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    })
  }

  create(aula: Aula): Observable<Aula> {
    return this.http.post<Aula>(this.baseUrl, aula).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }


  read(): Observable<Aula[]> {
    return this.http.get<Aula[]>(this.baseUrl).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  readById(id: string): Observable<Aula> {
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Aula>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  update(aula: Aula): Observable<Aula> {
    const url = `${this.baseUrl}/${aula.id}`
    return this.http.put<Aula>(url, aula).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  delete(id: string): Observable<Aula> {
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<Aula>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu um erro!", true);
    return EMPTY;
  }
}
