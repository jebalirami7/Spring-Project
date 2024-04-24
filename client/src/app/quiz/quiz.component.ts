import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { QuizService } from "../services/quiz.service";

@Component({
  selector: "app-quiz",
  templateUrl: "./quiz.component.html",
  styleUrls: ["./quiz.component.css"],
})
export class QuizComponent implements OnInit {
  questions: String[] = [];
  options: String[][] = [[]];
  selectedOptions: number[] = [];
  currentIndex: number = 0;
  currentQuestion: any;
  score: number = 0;
  quizCompleted: boolean = false;
  answerChosen: boolean = false;
  quiz: any = "test";

  constructor(private router: Router, private quizService: QuizService) {}

  ngOnInit(): void {
    // this.questions = [
    //   'Question 1?',
    //   'Question 2?',
    //   'Question 3?'
    // ];

    // this.options = [
    //   ["1", "2", "3"],
    //   ["1", "2", "3"],
    //   ["1", "2", "3"]
    // ];

    this.loadQuiz();
  }

  loadQuiz() {
    this.quizService.getQuiz(2).subscribe({
      next: (res) => {
        this.questions = res.questions;
        this.options = res.options;
        this.loadQuestion();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  loadQuestion(): void {
    this.currentQuestion = this.questions[this.currentIndex];
    this.answerChosen = this.selectedOptions[this.currentIndex] !== undefined;
  }

  selectOption(optionIndex: number): void {
    this.selectedOptions[this.currentIndex] = optionIndex;
    this.answerChosen = true;
  }

  prevQuestion(): void {
    if (this.currentIndex > 0) {
      this.currentIndex--;
      this.loadQuestion();
    }
  }

  nextQuestion(): void {
    if (this.currentIndex < this.questions.length - 1) {
      if (this.answerChosen) {
        this.currentIndex++;
        this.loadQuestion();
      } else {
        alert("Choose an answer before proceeding to the next question.");
      }
    }
  }
  submitQuiz(): void {
    this.quizCompleted = true;
  }
  restartQuiz(): void {
    this.currentIndex = 0;
    this.score = 0;
    this.quizCompleted = false;
    this.selectedOptions = [];
    this.loadQuestion();
  }
}
