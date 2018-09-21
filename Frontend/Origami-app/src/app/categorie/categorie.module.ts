import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CategorieComponent} from './categorie.component';
import {CategorieService} from './categorie.service';

const routes: Routes = [
    {path: 'categorie', component: CategorieComponent},
];

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        FormsModule,
        RouterModule.forChild(routes)
    ],

    providers: [
       CategorieService
    ],
    declarations: [
        CategorieComponent
    ]
})
export class CategorieModule { }