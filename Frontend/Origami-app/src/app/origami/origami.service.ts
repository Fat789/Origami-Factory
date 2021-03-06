import {Origami} from './origami';
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import {AppConfigurationService} from '../app-configuration.service';
import {Categorie} from '../categorie/categorie';


@Injectable()
export class OrigamiService {

    origamis: Array<Origami> = new Array<Origami>();

    categories: Array<Categorie> = new Array<Categorie>();

    apiUrl: string;
    constructor(private http: Http, private appConfig: AppConfigurationService) {
        this.apiUrl = appConfig.apiUrl + '/origami/';

        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.origamis = resp.json());

        this.http
            .get(appConfig.apiUrl + '/categorie/')
            .subscribe(resp => this.categories = resp.json());
    }

    public findAll() {
        return this.origamis;
    }

    public findAllCategories() {

        return this.categories;
    }



    public findById(id: number, http?: boolean): any {
        if (http) {
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

                    this.http
                    .post(this.apiUrl, origami)
                    .subscribe(
                        resp => this.origamis.push(origami),
                        err => console.log(err)
                    );
            } else {

                this.http
                    .put(this.apiUrl + origami.id, origami)
                    .subscribe(
                        resp => null,
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
    }
 }