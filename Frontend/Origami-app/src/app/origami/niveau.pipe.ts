import {Pipe} from '@angular/core';
import {Niveau} from './niveau.enum';

@Pipe({
    name: 'NiveauAsString'
})

export class NiveauAsStringPipe {
    transform(value: any) {
        if (isNaN(value)) {
            return value;
        }
        return Niveau[value].split(/(?=[A-Z])/).join().replace(',', ' ');
    }
}