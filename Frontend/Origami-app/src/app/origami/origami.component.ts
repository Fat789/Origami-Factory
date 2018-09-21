import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-origami',
  templateUrl: './origami.component.html',
  styleUrls: ['./origami.component.css']
})
export class OrigamiComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

//     public list() {
//         return this.eleveService.findAll();
//     }
//
//     public add() {
//         this.formEleve = new Eleve();
//     }
//
//     public edit(id: number) {
//         this.formEleve = this.eleveService.findById(id);
//     }
//
//     public save() {
//         this.eleveService.save(this.formEleve);
//         this.formEleve = null;
//     }
//
//     public cancel () {
//         this.formEleve = null;
//     }
//
//     public delete(id: number) {
//         this.eleveService.delete(this.eleveService.findById(id));
//     }
// }
//
// }
