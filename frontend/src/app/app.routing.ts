import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ContentModule } from "./components/content/content.module";
import { NotFoundComponent } from "./components/not-found/not-found.component";
import { AdminGuard } from "./guard/admin.guard";
import { CanActiveAuth } from "./guard/can-active-auth.guard";
import { CustomerGuard } from "./guard/customer.guard";
import { PicGuard } from "./guard/pic.guard";
import { LoginComponent } from "./pages/login/login.component";

const routes : Routes = [
    {
        path : '',
        redirectTo : '/login',
        pathMatch : 'full'
    },
    {
        path : 'login',
        component : LoginComponent,
        canActivate: [ CanActiveAuth ]
    },
    {
        path : 'dashboard',
        loadChildren : () => import('./pages/dashboard/dashboard.module').then(dashboard => dashboard.DashboardModule)
    },
    {
        path : 'profile',
        loadChildren : () => import('./pages/profile/profile.module').then(profile => profile.ProfiledModule)
    },
    {
        path : 'users',
        loadChildren : () => import('./pages/user/super-admin/user.module').then(users => users.UserModule)
    },
    {
        path : 'companies',
        loadChildren : () => import('./pages/company/company.module').then(companies => companies.CompanyModule),
        canLoad : [AdminGuard]
    },
    {
        path : 'products',
        loadChildren : () => import('./pages/product/super-admin/product.module').then(products => products.ProductModule),
    },
    {
        path : 'product-customer',
        loadChildren : () => import('./pages/product-customer/product-customer.module').then(productsCustomer => productsCustomer.ProductCustomerModule),
        canLoad : [AdminGuard]
    },
    {
        path : 'customers',
        loadChildren : () => import('./pages/user/pic/customer.module').then(customers => customers.CustomerModule),
        canLoad : [PicGuard]
    },
    {
        path : 'tickets/pic',
        loadChildren : () => import('./pages/ticket/pic/ticket.module').then(tickets => tickets.TicketModulePic),
        canLoad : [PicGuard]
    },
    {
        path : 'tickets/customer',
        loadChildren : () => import('./pages/ticket/customer/ticket.module').then(tickets => tickets.TicketModuleCustomer),
        canLoad : [CustomerGuard]
    }
    ,
    {
        path : 'products/customer',
        loadChildren : () => import('./pages/product/customer/product.module').then(products => products.ProductModuleCustomer),
        canLoad : [CustomerGuard]
    },
    {
        path : '**',
        component : NotFoundComponent
    }
] 

@NgModule({
    imports : [
        RouterModule.forRoot(routes), ContentModule
    ],
    exports : [
        RouterModule
    ]
})
export class AppRouting {}