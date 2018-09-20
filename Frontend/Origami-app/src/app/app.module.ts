import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {OrigamiComponent} from './origami/origami.component';
import {EtapeComponent} from './etape/etape.component';
import {CategorieComponent} from './categorie/categorie.component';
import {AdminComponent} from './admin/admin.component';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';

const routes: Routes = [
    {path: 'accueil', component: AccueilComponent},
    {path: 'categorie', component: CategorieComponent},
    {path: 'origami', component: OrigamiComponent},
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: '**', redirectTo: 'accueil', pathMatch: 'full'}
];


@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        OrigamiComponent,
        EtapeComponent,
        CategorieComponent,
        AdminComponent,
        CategorieComponent,
        AccueilComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(routes)
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
