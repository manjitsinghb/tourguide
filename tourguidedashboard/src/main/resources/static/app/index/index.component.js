import { Component } from 'angular2/core';
import { GoogleMapSearchAddress } from '/app/mapsearch/googlemapsearch.component';

@Component({
selector: 'index',
templateUrl: 'app/index/_index.html',
directives: [GoogleMapSearchAddress]
})

export class IndexComponent{

    findRoute(startAddress: MatchedAddress, destination: MatchedAddress) {
            var params = new Array();
            params['startAddress'] = startAddress.matchedAddress;
            params['destinationAddress'] = destination.matchedAddress;
            this.httpService.getHttpServiceCall("/routeAddress",params).map((res:Response) => res.json()).subscribe(data => this.routeAddress=data);
    }
}

