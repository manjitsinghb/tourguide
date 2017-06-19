import { Component } from 'angular2/core';
import { GoogleMapSearchAddress } from '/app/mapsearch/googlemapsearch.component';
import {HttpService} from 'app/common/services/http.services';

@Component({
selector: 'index',
templateUrl: 'app/index/_index.html',
directives: [GoogleMapSearchAddress],
providers: [HttpService]
})

export class IndexComponent{

    startAddress : string;
    destinationAddress : string;
    constructor(private httpService: HttpService){}

    findRoute() {
            var params = new Array();
            params['startAddress'] = this.startAddress;
            params['destination'] = this.destinationAddress;
            this.httpService.getHttpServiceCall("/routeAddress",params).map((res:Response) => res.json()).subscribe(data => this.routeAddress=data);
    }
}

