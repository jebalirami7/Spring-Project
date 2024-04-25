import { LectureDTO } from "./LectureDTO";


export interface ChapterDTO {
    id: number;
    title: string;
    courseMaterials: LectureDTO[];
}

