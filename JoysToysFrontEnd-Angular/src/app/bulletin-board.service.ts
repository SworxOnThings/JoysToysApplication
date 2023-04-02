import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { BulletinBoardMessage } from './bulletin-board-message';

@Injectable({
  providedIn: 'root'
})
export class BulletinBoardService {

  private url = 'http://localhost:8080/products'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  postMessage(message: BulletinBoardMessage) : Observable<BulletinBoardMessage> {
    return this.http.post<BulletinBoardMessage>(this.url, message, this.httpOptions).pipe(
      tap((newMessage: BulletinBoardMessage) => console.log(`new message posted: ${newMessage}`)),
      catchError(this.handleError<BulletinBoardMessage>('postMessage'))
    );
  }

  getMessages(id: number): Observable<BulletinBoardMessage[]> {
    return this.http.get<BulletinBoardMessage[]>(`${this.url}/${id}`).pipe(
      tap((messages: BulletinBoardMessage[]) => console.log(`got messages: ${messages}`)),
      catchError(this.handleError<BulletinBoardMessage[]>('getMessages', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
