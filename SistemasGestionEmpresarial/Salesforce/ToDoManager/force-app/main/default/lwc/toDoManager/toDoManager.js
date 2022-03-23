import { LightningElement, track } from 'lwc';

export default class ToDoManager extends LightningElement {
    time = "8:15 PM";
    greeting = "Good evening";

    connectedCallback(){
        this.getTime();

        setInterval(() => {
            this.getTime();
            console.log("Set interval called");
        }, 1000);
    }

    getTime() { 
        const date = new Date();
        const hour = date.getHours();
        const min = date.getMinutes();

        this.time = `${this.getHour(hour)}:${this.getDoubleDigit(min)} ${this.getMidDaty(hour)}`;
        
        this.setGreeting(hour);
    }

    getHour(hour){
        return hour == 0 ? 12 : hour > 12 ? (hour - 12) : hour;
    }

    getMidDaty(hour){
        return hour >= 12 ? "PM" : "AM";
    }

    getDoubleDigit(digit){
         return digit < 10 ? ("0" + digit): digit;
    }

    setGreeting(hour) {
        if (hour > 7 && hour < 14) {
            this.greeting = "Good Morning";
        } else if (hour >= 13 && hour < 20){
            this.greeting = "Good Afternooo";
        } else {
            this.greeting = "Good Evening";
        }
    }
}