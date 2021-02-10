import { Component, OnInit } from '@angular/core';
import {Pokemon} from '../pokemon';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponentComponent implements OnInit {

  // Attributes
  listPokemon: Array<Pokemon> = [];
  selectedValue: string;

  constructor() {
    const pokemon0 = new Pokemon(0, 'charmander');
    const pokemon1 = new Pokemon(1, 'ditto');
    const pokemon2 = new Pokemon(2, 'pikachu');
    const pokemon3 = new Pokemon(2, 'mew');
    this.listPokemon.push(pokemon0);
    this.listPokemon.push(pokemon1);
    this.listPokemon.push(pokemon2);
    this.listPokemon.push(pokemon3);

    this.selectedValue = '';
  }

  ngOnInit(): void {

  }

  search(): void{

  }



}
