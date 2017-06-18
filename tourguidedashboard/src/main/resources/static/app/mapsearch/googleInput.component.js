import { Component,Input,Output } from 'angular2/core';
import {HttpService} from 'app/common/services/http.services';
import {MatchedAddress} from 'app/common/domain/matchedAddress.domain';

@Component({
selector: 'GoogleMapAddressInput',
templateUrl: 'app/mapsearch/_googleInput.html',
providers: [HttpService]
})

export class GoogleMapAddressInputComponent {
   @Input() placeholderText: string;
   address : string;
    constructor(private httpService: HttpService){}

    selectAddress(selectedAddress : MatchedAddress) {
        this.address = selectedAddress.matchedAddress;
    }

    findMatchingAddress():Observable<MatchedAddress[]> {
        if(!this.address) {
            return;
        }
        var params = new Array();
        params['searchAddress'] = this.address;
        this.httpService.getHttpServiceCall("/matchAddress",params).map((res:Response) => <MatchedAddress[]>res.json()).subscribe(data => this.matchedAddress=data);
    }

}