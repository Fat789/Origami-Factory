export class Etape {

    public id: number;
    public numeroEtape: number;
    public description: string;
    public imageEtape: string;


    constructor(id: number, numeroEtape: number, description: string, imageEtape: string) {
        this.id = id;
        this.numeroEtape = numeroEtape;
        this.description = description;
        this.imageEtape = imageEtape;
    }
}