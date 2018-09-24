import {Origami} from '../origami/origami';

export class Etape {

    public id: number;
    public numeroEtape: number;
    public description: string;
    public imageEtape: string;
    public origamis: Array<Origami>;
    public origami: Origami;

    constructor(id?: number,
                numeroEtape?: number,
                description?: string,
                imageEtape?: string,
                origamis?: Array<Origami>,
                origami?: Origami) {
        this.id = id;
        this.numeroEtape = numeroEtape;
        this.description = description;
        this.imageEtape = imageEtape;
        this.origamis = origamis;
        this.origami = origami;
    }
}
