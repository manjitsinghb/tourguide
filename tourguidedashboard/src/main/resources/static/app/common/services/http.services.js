import {Injectable} from 'angular2/core';
import {Http,URLSearchParams, Response} from 'angular2/http';
import 'rxjs/add/operator/map';

@Injectable()
export class HttpService{
    constructor(private http: Http) {
    }

    getHttpServiceCall(url: string, data?:any) {
        var params = new URLSearchParams();
        for(let key in data) {
            params.set(key, data[key]);
        }
        return this.http.get(url,{search:params},{});
    }

    postHttpServiceCall(url: string, data?:any) {
        var params = new URLSearchParams();
        for(let key in data) {
            params.set(key, data[key]);
        }
        return this.http.post(url,{search:params},{}).map((res:Response) => res.json());
    }
}