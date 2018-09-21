import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './admin.component';
import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';

const routes: Routes = [
    {path: 'admin', component: AdminComponent},
];

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        FormsModule,
        RouterModule,
        RouterModule.forChild(routes),
        HttpModule,
    ],
    declarations: [
        AdminComponent
    ]
})
export class AdminModule { }