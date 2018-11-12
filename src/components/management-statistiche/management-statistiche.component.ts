import { StatisticheService } from './../../services/statistiche.service';
import { Component, OnInit } from '@angular/core';

//declare let google: any;

@Component({
  selector: 'app-management-statistiche',
  templateUrl: './management-statistiche.component.html',
  styleUrls: ['./management-statistiche.component.css','../../app/app.component.css']
})
export class ManagementStatisticheComponent implements OnInit {
  
 
  constructor(private statisticheService:StatisticheService) {}
  value:string;

  //IdAsset, tempo d'uso dell'asset in minuti, numero di usi 
  stats=new Array<number>();
  statsView = new Array<any>();
  k;
  somma;
  x;
  matStats= new Array<Array<any>>();
  ngOnInit() {
    this.statisticheService.getAllStats().subscribe(async(response)=>{
     await (this.stats=response);
     this.k=0;
     this.x=0;
     this.somma=0;

     for (let s=0;s<this.stats.length/3;s++)
     {
       this.somma+=this.stats[this.x+1];
       this.x+=3;
     }


     for (let i=0;i<this.stats.length/3;i++)
    {
      this.matStats[i]=new Array<any>();
      this.matStats[i][0]=this.stats[this.k];
      this.matStats[i][1]=this.stats[this.k+1];
      if(this.stats[this.k+2]!=0)
          this.matStats[i][2]=(this.stats[this.k+1]/this.stats[this.k+2]);
      else
          this.matStats[i][2]=0;
      if(this.somma!=0)
          this.matStats[i][3]=((this.stats[this.k+1]/this.somma)*100);
      else
          this.matStats[i][3]=0;
      this.k+=3;
    }

    });

    
    /*
    google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            let data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
                ['Work',     11],
                ['Eat',      2],
                ['Commute',  2],
                ['Watch TV', 2],
                ['Sleep',    7]
            ]);

            let options = {
                title: 'My Daily Activities'
            };

            let chart = new google.visualization.PieChart(document.getElementById('piechart'));

            chart.draw(data, options);
    */
  }


}

