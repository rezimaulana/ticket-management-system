import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ProductInsertComponent } from "./product-insert/product-insert.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { ProductUpdateComponent } from "./product-update/product-update.component";
import { ProductRouting } from "./product.routing";

@NgModule({
    declarations : [
        ProductListComponent, ProductInsertComponent, ProductUpdateComponent
    ],
    imports : [
        ProductRouting, CommonModule, FormsModule
    ],
    exports : [
        ProductListComponent, ProductInsertComponent, ProductUpdateComponent
    ]
})
export class ProductModule{}