import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {OrigamiComponent} from './origami.component';
import {OrigamiService} from './origami.service';


const routes: Routes = [
    {path: 'origami', component: OrigamiComponent},
];

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        FormsModule,
        RouterModule.forChild(routes)
    ],
    declarations: [
        OrigamiComponent
    ],
    providers: [OrigamiService]
})
export class OrigamiModule {
}