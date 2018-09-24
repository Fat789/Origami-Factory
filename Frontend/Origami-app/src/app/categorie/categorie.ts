import {Origami} from '../origami/origami';

export class Categorie {

    public id: number;
    public nom: string;
    public superCat: Categorie;
    public superCats: Array<Categorie>;
    public origamis: Array<Origami>;


    constructor(id?: number,
                nom?: string,
                superCat?: Categorie,
                superCats?: Array<Categorie>,
                origamis?: Array<Origami>) {
        this.id = id;
        this.nom = nom;
        this.superCat = superCat;
        this.superCats = superCats;
        this.origamis = origamis;
    }
}