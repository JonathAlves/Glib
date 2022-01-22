export class Game{
    idGame!: number;
    name!: string;
    synopsis!: string;
    releaseDate!: string;
    developer!: string;
    evaluation!: number;
    publisher!: string;
    platforms: string[] = [];    

    constructor(){}
}