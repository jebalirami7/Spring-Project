import { Quizz } from "./quizz";
import { Tutor } from "./tutor";

export interface Course {
    id: number;
    name: string;
    description: string;
    imagePath: string;
    creator: Tutor;
    subject: any;
    quizz: Quizz;
    rating: number;   
    duration: number; 
    isJoined: boolean;
}