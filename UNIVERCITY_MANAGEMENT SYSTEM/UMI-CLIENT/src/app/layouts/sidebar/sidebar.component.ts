import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { EtablissementService } from '../../services/etablissement.service';
import { Etablissement } from '../../models/etablissement.module';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  activeNavItem: string = '';
  constructor(
    private router: Router,
  ) {
    // Subscribe to router events to update activeNavItem
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.updateActiveNavItem();
      }
    });
  }

  // Function to update the activeNavItem based on the current route
  updateActiveNavItem() {
    const currentRoute = this.router.url.split('/')[1]; // Get the first segment of the URL
    this.activeNavItem = currentRoute || 'dashboard'; // Set a default in case no route matches
  }


}
