import { Component, OnInit } from '@angular/core';
import { BulletinBoardMessage } from '../bulletin-board-message';
import { BulletinBoardService } from '../bulletin-board.service';

@Component({
  selector: 'app-bulletin-board',
  templateUrl: './bulletin-board.component.html',
  styleUrls: ['./bulletin-board.component.css']
})
export class BulletinBoardComponent implements OnInit {

  messages: BulletinBoardMessage[] = [];

  constructor(private service: BulletinBoardService) { }

  ngOnInit(): void {
    this.getMessages();
  }

  getMessages(): void {
    this.service.getMessages()
      .subscribe(messages => this.messages = messages);
  }

  addMessage(name: string, message: string): void {
    const messageToSend = {userName: name, topic: "my_topic", timeStamp: new Date().toISOString(), message: message};
    this.messages.push(messageToSend);
    this.service.postMessage(messageToSend).subscribe();
  }
}
