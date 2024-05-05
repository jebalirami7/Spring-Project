import { LectureDTO } from "./DTO/LectureDTO";


export interface Chapter {
    id: number;
    title: string;
    courseMaterials: LectureDTO[];
    expanded?: boolean; 
  }