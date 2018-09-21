import {Origami} from './origami';
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';

@Injectable()
export class OrigamiService {

    origamis: Array<Origami> = new Array<Origami>();

    apiUrl: string;
    constructor(private http: Http) {

        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.origamis = resp.json());
    }

//     public findAll() {
//         return this.eleves;
//     }
//
//     public findById(id: number, http?: Boolean):any {
//
//         if(http){
//             return this.http
//                 .get(this.apiUrl + id);
//         }
//         for (const eleve of this.eleves) {
//             if (eleve.id === id) {
//                 return eleve;
//             }
//         }
//
//         return null;
//     }
//
//     public save(eleve: Eleve) {
//         if (eleve) {
//             if (!eleve.id) {
//                 if (this.eleves.length > 0) {
//                     eleve.id = this.eleves[this.eleves.length - 1].id + 1;
//                 } else {
//                     eleve.id = 1;
//                 }
//
//                 // this.eleves.push(eleve);
//                 this.http
//                     .post(this.apiUrl, eleve)
//                     .subscribe(
//                         resp => this.eleves.push(eleve),
//                         err => console.log(err)
//                     );
//             } else {
//
//                 this.http
//                     .put(this.apiUrl, eleve)
//                     .subscribe(
//                         resp => this.eleves.push(eleve),
//                         err => console.log(err)
//                     );
//
//
//             }
//         }
//     }
//
//     public delete(eleve: Eleve) {
//         const pos: number = this.eleves.indexOf(eleve);
//
//         this.http
//             .delete( this.apiUrl + eleve.id)
//             .subscribe(resp => this.eleves.splice(pos, 1),
//                 err => console.log(err),
//             );
//         // this.eleves.splice(pos, 1);
//     }
 }