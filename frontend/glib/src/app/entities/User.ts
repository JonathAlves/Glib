export class User{
    idUser!: number;
    nickname!: string;
    email!: string;
    password!: string;
    birth!: string;
    favoriteGames: string[] = [];    

    constructor(){}
}