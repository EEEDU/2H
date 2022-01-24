"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AlumnoListaComponent = void 0;
var core_1 = require("@angular/core");
var AlumnoListaComponent = /** @class */ (function () {
    function AlumnoListaComponent() {
        this.alumos = [
            { nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: 2 / 28 / 1958, sexo: 'Hombre' },
            { nombre: 'Eduardo', apellidos: 'Guerrero', direccion: 'Zaragoza', edad: 9 / 15 / 2002, sexo: 'Hombre' },
        ];
    }
    AlumnoListaComponent.prototype.getNumTodos = function () {
        return this.alumnos.length;
    };
    AlumnoListaComponent.prototype.getNumHombres = function () {
        return this.alumnos.filter(function (a) { return a.sexo == "Hombre"; }).length;
    };
    AlumnoListaComponent.prototype.getNumMujeres = function () {
        return this.alumnos.filter(function (a) { return a.sexo == "Mujer"; }).length;
    };
    AlumnoListaComponent = __decorate([
        core_1.Component({
            selector: 'lista-alumno',
            templateUrl: 'app/Alumno/AlumnoLista.component.html',
            styleUrls: ['app/Alumno/Alumno.component.css']
        })
    ], AlumnoListaComponent);
    return AlumnoListaComponent;
}());
exports.AlumnoListaComponent = AlumnoListaComponent;
//# sourceMappingURL=AlumnoLista.component.js.map