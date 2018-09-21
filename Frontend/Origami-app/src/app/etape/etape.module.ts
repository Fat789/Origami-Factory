import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {EtapeComponent} from './etape.component';



const routes: Routes = [
    {path: 'etape', component: EtapeComponent},
];

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        FormsModule,
        RouterModule,
        RouterModule.forChild(routes)
    ],
    declarations: [
        EtapeComponent
    ]
})
export class EtapeModule { }