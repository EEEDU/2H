"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AlumnoTituloPipe = void 0;
var core_1 = require("@angular/core");
var AlumnoTituloPipe = /** @class */ (function () {
    function AlumnoTituloPipe() {
    }
    AlumnoTituloPipe.prototype.transform = function (value, sexo) {
        if (sexo = 'Hombre') {
            return "Sr. " + value;
        }
        else {
            return "Sra. " + value;
        }
    };
    AlumnoTituloPipe = __decorate([
        core_1.Pipe({
            name: 'alumnoTitulo'
        })
    ], AlumnoTituloPipe);
    return AlumnoTituloPipe;
}());
exports.AlumnoTituloPipe = AlumnoTituloPipe;
//# sourceMappingURL=AlumnoTitulo.pipe.js.map