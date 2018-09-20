import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CategorieComponent} from './categorie.component';

const routes: Routes = [
    {path: 'categorie', component: CategorieComponent},
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
        CategorieComponent
    ]
})
export class CategorieModule { }