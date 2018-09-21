import {Component, OnInit} from '@angular/core';
import {Etape} from './etape';
import {EtapeService} from './etape.service';

@Component({
    selector: 'app-etape',
    templateUrl: './etape.component.html',
    styleUrls: ['./etape.component.css']
})
export class EtapeComponent implements OnInit {
    formEtape: Etape;

    constructor(private etapeService: EtapeService) {

    }

    ngOnInit() {
    }

    public add() {
        this.formEtape = new Etape();
    }

    public edit(etape: Etape) {
        this.formEtape = Etape;
    }

    public create() {
        this.EtapeService.save(this.formEtape);
        this.formEtape = null;
    }

    public cancel() {
        this.formEtape = null;
    }

    public delete(etape: Etape) {
        this.EtapeService.delete(etape);
        this.formEtape = null;
    }
}