"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AlumnosCountComponent = void 0;
var core_1 = require("@angular/core");
var AlumnosCountComponent = /** @class */ (function () {
    function AlumnosCountComponent() {
        this.todos = 0;
        this.hombres = 0;
        this.mujeres = 0;
    }
    AlumnosCountComponent = __decorate([
        core_1.Component({
            selector: 'cuantos-alumnos',
            templateUrl: 'app/Alumno/AlumnoCount.component.html',
            styleUrls: ['app/Alumno/AlumnoCount.component.css']
        })
    ], AlumnosCountComponent);
    return AlumnosCountComponent;
}());
exports.AlumnosCountComponent = AlumnosCountComponent;
//# sourceMappingURL=AlumnoCount.component.js.map