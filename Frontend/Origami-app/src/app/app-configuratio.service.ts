import {Injectable} from '@angular/core';

@Injectable()
export class AppConfigurationService {

    apiUrl: string = 'http://localhost:8080/LA-Factory/api';
}