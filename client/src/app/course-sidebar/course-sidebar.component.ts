import { Component, OnInit } from "@angular/core";
import { Chapter } from "../entities/Chapter";
import { LectureService } from "../services/lecture.service";
import { ChapterService } from "../services/chapter.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-course-sidebar",
  templateUrl: "./course-sidebar.component.html",
  styleUrl: "./course-sidebar.component.css",
})
export class CourseSidebarComponent implements OnInit {
  chapters: Chapter[] = [];
  courseId: string = "";

  constructor(
    private service: LectureService,
    private chapterService: ChapterService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const segments = this.route.snapshot.url;
    if (segments.length > 0) {
      this.courseId = segments[segments.length - 1].path;
    }
    this.chapterService
      .getAllCourseChapters(this.courseId)
      .subscribe((chapters) => {
        this.chapters = chapters.map((chapter) => {
          return this.chapterService.convertToEntity(chapter);
        });
      });
  }

  toggleChapter(section: Chapter) {
    section.expanded = !section.expanded;
  }

  openMaterial(id: number) {
    this.service.setData(id);
  }
}
