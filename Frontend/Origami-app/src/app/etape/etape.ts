export class Etape {

    public id: number;
    public numeroEtape: number;
    public description: string;
    public imageEatpe: string;


    constructor(id: number, numeroEtape: number, description: string, imageEatpe: string) {
        this.id = id;
        this.numeroEtape = numeroEtape;
        this.description = description;
        this.imageEatpe = imageEatpe;
    }
}