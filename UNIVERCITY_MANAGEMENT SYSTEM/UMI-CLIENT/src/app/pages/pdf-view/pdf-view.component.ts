import {Component, OnInit} from '@angular/core';
import { GcPdfViewer } from '@grapecity/gcpdfviewer';
import {ActivatedRoute, Router} from "@angular/router";
import {SectionService} from "../../services/section.service";
import {Section} from "../../models/section.module";
import formatters from "../../../assets/vendor/chart.js/core/core.ticks";
import {ScheduleService} from "../../services/schedule.service";
import {Schedule} from "../../models/schedule.module";
@Component({
  selector: 'app-pdf-view',
  templateUrl: './pdf-view.component.html',
  styleUrl: './pdf-view.component.css'
})
export class PdfViewComponent implements OnInit{
  constructor(
    private route: ActivatedRoute,
    private scheduleService: ScheduleService
  ) {}
  title = 'viewer-app';
  fileLinkParam:any;
  selectedSchedule: Schedule = {name:'',schedule:'',created_at:'',section:{id:0,name:'',description:'',slug:''}};
  secID:string="0";
  secIDN:number=0;
  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      const SectionID = params.get('id');
      this.secID+=SectionID;
      this.secIDN=Number(SectionID);
      this.scheduleService.getScheduleBySectionId(this.secIDN).subscribe(
        (schedule: Schedule) => {
          this.selectedSchedule = schedule;
          this.fileLinkParam=this.selectedSchedule.schedule;
          console.log("File Link"+this.fileLinkParam)
          const finaleLink="assets/uploads/emp.pdf";
          console.log("File Link:",this.fileLinkParam);
          const viewer = new GcPdfViewer("#viewer", {
            workerSrc: "/documents-api-pdfviewer/demos/product-bundles/build/gcpdfviewer.worker.js",
            restoreViewStateOnLoad: false
          });
          viewer.addDefaultPanels();
          console.log(finaleLink)
          viewer.open(finaleLink);
        },
        (error) => {
          console.error('Error fetching Section:', error);
        }
      );
    });
  }
}
