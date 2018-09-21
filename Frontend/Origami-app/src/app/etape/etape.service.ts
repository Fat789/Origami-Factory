import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Etape} from './etape';
import {AppConfigurationService} from '../app-configuration.service';


@Injectable()
export class EtapeService {
    apiUrl: string;
    etapes: Array<Etape>;
    etape: Etape;

    constructor(private http: Http, private appConfig: AppConfigurationService) {
        this.apiUrl = this.appConfig.apiUrl + '/etape';
        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.etapes = resp.json());
    }

    public findAll() {
        return this.etapes;
    }

    public findById(id: number, http?: boolean): any {
        if (http) {
            return this.http
                .get(this.appConfig.apiUrl + '/etape/' + id);
        }

        for (const etape of this.etapes) {
            if (etape.id === id) {
                return etape;
            }
        }

        return null;
    }

    public save(etape: Etape) {
        if (etape) {
            if (!etape.id) {
                if (this.etapes.length > 0) {
                    etape.id = this.etapes[this.etapes.length - 1].id + 1;
                } else {
                    etape.id = 1;
                }

                this.http
                    .post(this.appConfig.apiUrl + '/etape', etape)
                    .subscribe(
                        resp => this.etapes.push(etape),
                        err => console.log(err)
                    );
            } else {
                this.http
                    .put(this.appConfig.apiUrl + '/etape/' + etape.id, etape)
                    .subscribe(
                        resp => null,
                        err => console.log(err)
                    );
            }
        }
    }

    public delete(etape: Etape) {
        const pos: number = this.etapes.indexOf(etape);

        this.http
            .delete(this.appConfig.apiUrl + '/etape/' + etape.id)
            .subscribe(
                resp => this.etapes.splice(pos, 1),
                err => console.log(err)
            );
    }
}