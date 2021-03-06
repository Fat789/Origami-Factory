import {Categorie} from '../categorie/categorie';

export class Origami {

    public id: number;
    public nom: string;
    public tempsRea: number;
    public nbFeuille: number;
    public niveau: number;
    public note: number;
    public actif: boolean;
    public youtube: string;
    public imageOri: string;
    public categorie: Categorie;




    constructor(id?: number, nom?: string, tempsRea?: number, nbFeuille?: number, niveau?: number, note?: number, actif?: boolean,
                youtube?: string, imageOri?: string, categorie?: Categorie) {
        this.id = id;
        this.nom = nom;
        this.tempsRea = tempsRea;
        this.nbFeuille = nbFeuille;
        this.niveau = niveau;
        this.note = note;
        this.actif = actif;
        this.youtube = youtube;
        this.imageOri = imageOri;
        this.categorie = categorie;
    }
}