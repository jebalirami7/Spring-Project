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
  options: any[] = [];
  selectedOptions: number[] = [];
  currentIndex: number = 0;
  currentQuestion: any;
  score: number = 0;
  quizCompleted: boolean = false;
  answerChosen: boolean = false;
  quiz: any = "test";

  constructor(private router: Router, private quizService: QuizService) {}

  ngOnInit(): void {
    this.loadQuiz();
  }

  loadQuiz() {
    this.quizService.getQuiz(1).subscribe({
      next: (res) => {
        for (let i = 0; i < res.questions.length; i++) {
          this.questions.push(res.questions[i].question);
          this.options.push(res.questions[i].options);
        }
        console.log(this.options);
                
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
