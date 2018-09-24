import { Component, OnInit } from '@angular/core';
import {OrigamiService} from './origami.service';
import {Origami} from './origami';
import {Categorie} from '../categorie/categorie';

@Component({
  selector: 'app-origami',
  templateUrl: './origami.component.html',
  styleUrls: ['./origami.component.css']
})
export class OrigamiComponent implements OnInit {

  private formOrigami: Origami= null;

  constructor(private origamiService: OrigamiService) { }

  ngOnInit() {
  }

    public list() {
        return this.origamiService.findAll();
    }

    public listCategories() {
        return this.origamiService.findAllCategories();
    }
    public add() {
        this.formOrigami = new Origami();
        this.formOrigami.categorie = new Categorie();
    }

    public edit(id: number) {
        this.formOrigami = this.origamiService.findById(id);
        this.formOrigami.categorie = new Categorie();
    }

    public save() {
        this.origamiService.save(this.formOrigami);
        this.formOrigami = null;
        window.location.reload();
    }

    public cancel () {
        this.formOrigami = null;
    }

    public delete(id: number) {
        this.origamiService.delete(this.origamiService.findById(id));
    }

}
