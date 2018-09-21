import {Origami} from './origami';
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import {AppConfigurationService} from '../app-configuratio.service';


@Injectable()
export class OrigamiService {

    origamis: Array<Origami> = new Array<Origami>();

    apiUrl: string;
    constructor(private http: Http, private appConfig: AppConfigurationService) {
        this.apiUrl = appConfig.apiUrl + '/origami/';

        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.origamis = resp.json());
    }

    public findAll() {
        return this.origamis;
    }

    public findById(id: number, http?: Boolean):any {

        if(http){
            return this.http
                .get(this.apiUrl + id);
        }
        for (const origami of this.origamis) {
            if (origami.id === id) {
                return origami;
            }
        }

        return null;
    }

    public save(origami: Origami) {
        if (origami) {
            if (!origami.id) {
                if (this.origamis.length > 0) {
                    origami.id = this.origamis[this.origamis.length - 1].id + 1;
                } else {
                    origami.id = 1;
                }

                // this.origamis.push(origami);
                this.http
                    .post(this.apiUrl, origami)
                    .subscribe(
                        resp => this.origamis.push(origami),
                        err => console.log(err)
                    );
            } else {

                this.http
                    .put(this.apiUrl, origami)
                    .subscribe(
                        resp => this.origamis.push(origami),
                        err => console.log(err)
                    );


            }
        }
    }

    public delete(origami: Origami) {
        const pos: number = this.origamis.indexOf(origami);

        this.http
            .delete( this.apiUrl + origami.id)
            .subscribe(resp => this.origamis.splice(pos, 1),
                err => console.log(err),
            );
        // this.origamis.splice(pos, 1);
    }
 }