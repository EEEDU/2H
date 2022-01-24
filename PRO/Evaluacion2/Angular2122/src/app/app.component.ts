import { Component } from '@angular/core';

@Component({
    selector: 'my-app',
    template: `
        <lista-alumno></list-alumno>
    `,
        //ngIf == true --> visible, nfIf == false --> invisible
})
export class AppComponent {
    visible: boolean = true;

    onClick(): void {
        this.visible = false;
    }
}