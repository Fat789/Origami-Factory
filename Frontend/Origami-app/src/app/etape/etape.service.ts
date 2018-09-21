import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Etape} from './etape';
import {AppConfigurationService} from '../app-configuration.service';


@Injectable()
export class EtapeService {
    apiUrl: string;
    etapes: Array<Etape>;
    etape: Etape;

    constructor(private http: Http, private appConfig: AppConfigurationService, private etapeService: EtapeService) {
        this.apiUrl = this.appConfig.apiUrl + 'etape/';
        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.etapes = resp.json());
    }

    public findAll() {
        return this.etapes;
    }

    public findById(id: number) {
        this.http
            .get(this.apiUrl + id)
            .subscribe(resp => {
                this.etape = resp.json()
                this.refresh();
            });
    }

    public refresh() {
    }

    public save(salon: Etape) {
        if (this.etape.id) {
            this.update(this.etape);
        } else {
            this.create(this.etape);
        }
    }

    public create(etape: Etape) {
        this.http
            .post(this.apiUrl, etape)
            .subscribe(resp => this.etapes.push(resp.json()));
    }

    public update(etape: Etape) {
        this.http
            .put(this.apiUrl + etape.id, etape)
            .subscribe();
    }

    public delete(etape: Etape) {
        const pos: number = this.etapes.indexOf(etape);

        this.http
            .delete(this.apiUrl + etape.id)
            .subscribe(resp => this.etapes.splice(pos, 1));
    }
}