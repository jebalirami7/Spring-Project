import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NavbarComponent,CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  sidebarItems = [
    { iconClass: 'layout-grid-line', label: 'Dashboard' },
    
    { iconClass: 'user-2-line', label: 'tutors' },
    { iconClass: 'user-line', label: 'students' },
    { iconClass: 'line-chart-line', label: 'Activity' },
    { iconClass: 'customer-service-line', label: 'Support' }
  ];
  bottomSidebarItems = [
    { iconClass: 'settings-3-line', label: 'Settings' },
    { iconClass: 'logout-box-r-line', label: 'Logout' }
  ];
  cards = [
    { title: 'Total Tutors', value: 20, icon: 'user-2-line', stats: ['65%', 10, 2] },
    { title: 'Total Students', value: 1145, icon: 'user-line', stats: ['82%', 230, 45] },
    { title: 'Published Courses', value: 102, icon: 'calendar-2-line', stats: ['27%', 31, 23] },
    
  ];
  tutors = [
    { imageUrl: '../../assets/images/promo.jpg', name: 'habib' },
    { imageUrl: '../../assets/images/promo.jpg',  name: 'habib' },
    { imageUrl: '../../assets/images/promo.jpg',  name: 'habib' },
    { imageUrl: '../../assets/images/promo.jpg', name: 'habib' },
    { imageUrl: '../../assets/images/promo.jpg',  name: 'habib' },
    { imageUrl: '../../assets/images/promo.jpg',  name: 'habib' },

  ];
  students = [
    { name: 'Cameron Williamson', age: '30', filiere: 'Male', annee: '1er',  },
    { name: 'George Washington', age: '30', filiere: 'Male', annee: '2eme',  },
    { name: 'Thomas Jefferson', age: '29', filiere: 'Male', annee: '2eme',  },
    { name: 'James Madison', age: '29', filiere: 'Male', annee: '1er',  },
    { name: 'Andrew Jackson', age: '28', filiere: 'Male', annee: '3eme',  }
  ];
}
