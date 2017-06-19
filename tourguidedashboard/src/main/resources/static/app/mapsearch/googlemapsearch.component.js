import { Component,Input,Output,EventEmitter } from 'angular2/core';
import {HttpService} from 'app/common/services/http.services';
import {MatchedAddress} from 'app/common/domain/matchedAddress.domain';

@Component({
selector: 'GoogleMapSearchAddress',
templateUrl: 'app/mapsearch/_googleMap.html',
providers: [HttpService]
})

export class GoogleMapSearchAddress {
   @Input() placeholderText: string;
   @Input() address : string;
   @Output() addressChange = new EventEmitter<string>();
   showSuggestions=true;

    constructor(private httpService: HttpService){}

    selectAddress(selectedAddress : MatchedAddress) {
        this.address = selectedAddress.matchedAddress;
        this.addressChange.emit(this.address);
        this.showSuggestions=false;
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