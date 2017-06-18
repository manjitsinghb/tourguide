import { Component,Input,Output } from 'angular2/core';
import {HttpService} from 'app/common/services/http.services';
import {MatchedAddress} from 'app/common/domain/matchedAddress.domain';
import {GoogleMapAddressInputComponent} from 'app/mapsearch/googleInput.component';

@Component({
selector: 'GoogleMapAddress',
templateUrl: 'app/mapsearch/_googleMap.html',
directives: [GoogleMapAddressInputComponent],
providers: [HttpService]
})

export class GoogleMapSearchComponent {

    constructor(private httpService: HttpService){}

    findRoute(startAddress: MatchedAddress, destination: MatchedAddress) {
        var params = new Array();
        params['startAddress'] = startAddress.matchedAddress;
        params['destinationAddress'] = destination.matchedAddress;
        this.httpService.getHttpServiceCall("/routeAddress",params).map((res:Response) => res.json()).subscribe(data => this.routeAddress=data);
    }
}