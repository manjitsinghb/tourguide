import { Component } from 'angular2/core';
import { GoogleMapSearchComponent } from '/app/mapsearch/googlemapsearch.component';

@Component({
selector: 'index',
templateUrl: 'app/index/_index.html',
directive: [GoogleMapSearchComponent]
})

export class IndexComponent{
}