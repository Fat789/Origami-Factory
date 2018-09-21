import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {OrigamiComponent} from './origami/origami.component';
import {CategorieComponent} from './categorie/categorie.component';
import {AdminComponent} from './admin/admin.component';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {CategorieModule} from './categorie/categorie.module';
import {OrigamiModule} from './origami/origami.module';
import {EtapeModule} from './etape/etape.module';
import {AppConfigurationService} from './app-configuration.service';

const routes: Routes = [
    {path: 'accueil', component: AccueilComponent},
    {path: 'categorie', component: CategorieComponent},
    {path: 'origami', component: OrigamiComponent},
    {path: '', redirectTo: 'accueil', pathMatch: 'full'},
    {path: '**', redirectTo: 'accueil', pathMatch: 'full'}
];


@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        AccueilComponent,
        AdminComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(routes),
        CategorieModule,
        OrigamiModule,
        EtapeModule
    ],
    providers: [
        AppConfigurationService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
