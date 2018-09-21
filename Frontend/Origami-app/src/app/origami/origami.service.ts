@Injectable()
export class EleveService {
    eleves: Array<Eleve> = new Array<Eleve>();

    apiUrl: string;
    constructor(private http: Http, private appConfig: AppConfigService) {
        this.apiUrl = appConfig.apiUrl + '/eleve/';

        this.http
            .get(this.apiUrl)
            .subscribe(resp => this.eleves = resp.json());

        // constructor() {
        //   this.eleves.push(new Eleve(1, Civilite.Monsieur, 'LALEOUSE', 'Baptiste', new Date(1993, 10, 23)));
        //   this.eleves.push(new Eleve(2, Civilite.Monsieur, 'LAVELLE', 'Adrien', new Date(1993, 10, 17)));
        //   this.eleves.push(new Eleve(3, Civilite.Madame, 'FOURNY', 'Emeline', new Date(1989, 5, 6)));
    }

    public findAll() {
        return this.eleves;
    }

    public findById(id: number, http?: Boolean):any {

        if(http){
            return this.http
                .get(this.apiUrl + id);
        }
        for (const eleve of this.eleves) {
            if (eleve.id === id) {
                return eleve;
            }
        }

        return null;
    }

    public save(eleve: Eleve) {
        if (eleve) {
            if (!eleve.id) {
                if (this.eleves.length > 0) {
                    eleve.id = this.eleves[this.eleves.length - 1].id + 1;
                } else {
                    eleve.id = 1;
                }

                // this.eleves.push(eleve);
                this.http
                    .post(this.apiUrl, eleve)
                    .subscribe(
                        resp => this.eleves.push(eleve),
                        err => console.log(err)
                    );
            } else {

                this.http
                    .put(this.apiUrl, eleve)
                    .subscribe(
                        resp => this.eleves.push(eleve),
                        err => console.log(err)
                    );


            }
        }
    }

    public delete(eleve: Eleve) {
        const pos: number = this.eleves.indexOf(eleve);

        this.http
            .delete( this.apiUrl + eleve.id)
            .subscribe(resp => this.eleves.splice(pos, 1),
                err => console.log(err),
            );
        // this.eleves.splice(pos, 1);
    }
}